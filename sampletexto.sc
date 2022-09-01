// SampleTexto
// A class to create synths form a sound files in a folder

SampleTexto {

	var <sampleDictionary;
	var <sampleMonoDictionary;
	var <sampleStereoDictionary;

	// Constructor (Método constructor)
	*new {
		^super.new.init;
	}

	// Read folder of Recordings path (lee carpetas del directorio Recordings)
	init { |server, path = "/sampletexto/"|

		sampleDictionary = Dictionary.new;

		sampleDictionary.add(\smp -> PathName(Platform.recordingsDir +/+ path).entries.collect({ |grabacion| Buffer.read(server ? Server.default, grabacion.fullPath) }));
	}

	// Create a mono Dictionary and a stereo Dictionary (crea un diccionario mono y uno estéreo)
	stsel {
		sampleMonoDictionary = sampleDictionary[\smp].select{ |item| item.numChannels == 1 };
		sampleStereoDictionary = sampleDictionary[\smp].select{ |item| item.numChannels == 2 };
	}

	// Read sounds from the general Dictionary (lee sonidos de la carpeta general)
	st { |num1 = 0|
		^this.sampleDictionary[\smp][num1];
	}

	// Read sounds from mono Dictionary (lee sonidos de la carpeta mono)
	stm { |num2 = 0|
		^this.sampleMonoDictionary[num2];
	}

	// Read sounds from stereo Dictionary (lee sonidos de la carpeta estéreo)
	sts { |num3 = 0|
		^this.sampleStereoDictionary[num3];
	}

	// Create mono synths from mono Dictionary (crear Synths del diccionario mono)
	monosynth {|num = (sampleMonoDictionary.size - 1)|
			(0..num).do{|it|
				this.sampleMonoDictionary[it].normalize;
				SynthDef("m%".format(it), {|rate=1, sp=0, at=0.001, sus=1, rel=0.001, pan=0, amp=1, out=0|
					var son, hpf, pne, env;
					son=PlayBuf.ar(1, this.sampleMonoDictionary[it].bufnum, rate, 1, sp * this.sampleDictionary[\smp][it].numFrames, 0);
					hpf=HPF.ar(son, 20);
					pne=Pan2.ar(hpf, pan, amp);
					env=EnvGen.kr(Env.new([0, 1, 1, 0], [at, sus * this.sampleMonoDictionary[it].duration, rel]), doneAction: 2);
					Out.ar(out, pne * env);
				}).add;
			}
	}

	// Create stereo synths from stereo Dictionary (crear Synths del diccionario estéreo)
	stereosynth {|num = (sampleStereoDictionary.size - 1)|
			(0..num).do{|it|
				this.sampleStereoDictionary[it].normalize;
				SynthDef("s%".format(it), {|rate=1, sp=0, at=0.001, sus=1, rel=0.001, amp=1, out=0|
					var son, hpf, env;
				son=PlayBuf.ar(2, this.sampleStereoDictionary[it].bufnum, rate, 1, sp * this.sampleStereoDictionary[it].numFrames, 0);
					hpf=HPF.ar(son, 20);
					env=EnvGen.kr(Env([0, 1, 1, 0], [at, sus * this.sampleStereoDictionary[it].duration, rel]), doneAction: 2);
					Out.ar(out, (son * env) * amp);
				}).add;
			}
	}

	// Specify the number of samples in a folder (cantidad de sonidos en la carpeta)
	info {
		("total: " ++ sampleDictionary[\smp].size).postln;
		("mono: " ++ sampleMonoDictionary.size).postln;
		("stereo: " ++ sampleStereoDictionary.size).postln;
	}
}
