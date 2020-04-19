SampleTexto{

	var <sampleDictionary;

	*new {
		^super.new.init
	}

	init {|server, path = "/sampletexto"|

		sampleDictionary = Dictionary.new;
		sampleDictionary.add(\smp -> PathName(Platform.recordingsDir +/+ path).entries.collect({arg grabacion; Buffer.read(server ? Server.default, grabacion.fullPath)}));
	}
}