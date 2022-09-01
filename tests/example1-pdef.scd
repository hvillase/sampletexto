s.boot;

o=SampleTexto.new;
o.stsel;
o.info;
o.stereosynth();

Synth(\s0);
Synth(\s2);
Synth(\s4);

(
Pdef(\sampletexto, Ppar([
	Pbind(\instrument, \s0,
		\dur, 1),
	Pbind(\instrument, \s2,
		\dur, 0.5),
	Pbind(\instrument, \s4,
		\dur, 2
	)
])
).play
)