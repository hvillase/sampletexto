// Read samples by index

SampleTexto {

	var <sampleDictionary;

	*new {
		^super.new.init
	}

	init {|server, path = "/sampletexto"|

		sampleDictionary = Dictionary.new;
		sampleDictionary.add(\smp -> PathName(Platform.recordingsDir +/+ path).entries.collect({arg grabacion; Buffer.read(server ? Server.default, grabacion.fullPath)}));
	}

	st {|num = 0|
		^this.sampleDictionary[\smp][num]; // para acceder con play desde afuera es importante el ^
	}
}