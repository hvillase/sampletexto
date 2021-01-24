//===================================//
// SampleTexto: read sounds by index //
// Author: Hernani Villasenor        //
// Collaboration: Sam Roig            //
//===================================//

SampleTexto {

	var <sampleDictionary1;
	var <sampleDictionary2;

	*new {
		^super.new.init
	}

	init {|server, pathRec = "/sampletexto", path = "/home"|
		// versión original: lee carpetas del directorio Recordings (read folder of Recordings path)
		sampleDictionary1 = Dictionary.new;
		sampleDictionary1.add(\smp1 -> PathName(Platform.recordingsDir +/+ pathRec).entries.collect({arg grabacion; Buffer.read(server ? Server.default, grabacion.fullPath)}));

		// lee carpetas en cualquier ruta, línea implementada por Sam Roig (read any folder, just audio files)
		sampleDictionary2 = Dictionary.new;
		sampleDictionary2.add(\smp2 -> SoundFile.collectIntoBuffers(path: path, server: Server.default));
	}

	st1 {|num1 = 0|
		^this.sampleDictionary1[\smp1][num1]; // para acceder con play desde afuera es importante el ^
	}

	st2 {|num2 = 0|
		^this.sampleDictionary2[\smp2][num2]; // para acceder con play desde afuera es importante el ^
	}
}