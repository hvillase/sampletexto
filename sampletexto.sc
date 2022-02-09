SampleTexto {

	var <sampleDictionary; // para cargar sonidos
	var <sampleMonoDictionary; // para seleccionar sonidos mono
	var <sampleStereoDictionary; // para seleccionar sonidos estereo

	*new {
		^super.new.init;
	}

	// lee carpetas del directorio Recordings (read folder of Recordings path)
	init { |server, path = "/sampletexto/"|

		sampleDictionary = Dictionary.new;

		sampleDictionary.add(\smp -> PathName(Platform.recordingsDir +/+ path).entries.collect({ arg grabacion; Buffer.read(server ? Server.default, grabacion.fullPath) }));
	}

	stsel {
		sampleMonoDictionary = sampleDictionary[\smp].select{arg item; item.numChannels == 1 };
		sampleStereoDictionary = sampleDictionary[\smp].select{arg item; item.numChannels == 2 };
	}

	st { |num1 = 0|
		^this.sampleDictionary[\smp][num1];
	}

	stm { |num2 = 0|
		^this.sampleMonoDictionary[num2];
	}

	sts { |num3 = 0|
		^this.sampleStereoDictionary[num3];
	}

	// cantidad de sonidos en la carpeta (number of samples in folder)
	info {
		("total: " ++ sampleDictionary[\smp].size).postln;
		("mono: " ++ sampleMonoDictionary.size).postln;
		("stereo: " ++ sampleStereoDictionary.size).postln;
	}
}
