// SampleTexto
// A class to read sound files from a folder by index

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

	// Specify the number of samples in a folder (cantidad de sonidos en la carpeta)
	info {
		("total: " ++ sampleDictionary[\smp].size).postln;
		("mono: " ++ sampleMonoDictionary.size).postln;
		("stereo: " ++ sampleStereoDictionary.size).postln;
	}
}
