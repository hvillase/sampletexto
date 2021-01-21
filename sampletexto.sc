//===================================//
// SampleTexto: read sounds by index //
// Author: Hernani Villasenor        //
// Colaboration: Sam Roig            //
//===================================//

SampleTexto {

	var <sampleDictionary1;
	var <sampleDictionary2;

	*new {
		^super.new.init
	}

	init {|server, pathRec = "/sampletexto", path = "/home"|
// lee folder dentro del directorio Recordings
		sampleDictionary1 = Dictionary.new;
		sampleDictionary1.add(\smp -> PathName(Platform.recordingsDir +/+ pathRec).entries.collect({arg grabacion; Buffer.read(server ? Server.default, grabacion.fullPath)}));

// lee folder en cualquier ruta, línea implementada por Sam Roig
		sampleDictionary2 = Dictionary.new;
		sampleDictionary2.add(\smp2 -> SoundFile.collectIntoBuffers(path: path, server: Server.default));
	}

	st {|num = 0|
		^this.sampleDictionary1[\smp][num]; // para acceder con play desde afuera es importante el ^
	}

	st2 {|num2 = 0|
		^this.sampleDictionary2[\smp2][num2]; // para acceder con play desde afuera es importante el ^
	}
}