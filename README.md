# SampleTexto
Reading samples by index. This is a very experimental class. You can read an audio sample from a folder by its index.

## Preparing SampleTexto
1 Download or clone the folder of SampleTexto.

2 Put it in your SuperCollider Extensions folder.

3 Create a folder in the SuperCollider Recordings folder and name it *sampletexto*.

4 Put your samples in this folder.

## Start SampleTexto
```
r = SampleTexto.new
```
## Test SampleTexto
```
r.sampleDictionary // to see the samples in your folder
r.st(0).play // to play the first sample in your folder; change the number to access different index.
r.st(0).plot // to see the waveform of your sample.
r.stsel // to create one dictionarie for mono sounds and one for stereo sounds
r.stm(0).play // to play the first mono sound
r.sts(0).play // to play the first stereo sound
r.monosynth(); // to create one SynthDef for each mono audio file
r.stereosynth(); // to create one SynthDef for each stereo audio file
r.info // says how many sounds are in total
```
## Change folder path
```
r.init(path: "/path/to/Recordings/your_folder/");
```
## Example with Synth + Pdef
```
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
```
## SynthDef arguments
```
// mono synth
rate: 1      // pitch rate
sp: 0        // start position
at: 0.001    // atack
sus: 1       // sustain
rel: 0.001   // release
pan: 0       // stereo pan
amp: 1       // volume
out: 0       // output (L)

// stereo synth
rate: 1      // pitch rate
sp: 0        // start position
at: 0.001    // atack
sus: 1       // sustain
rel: 0.001   // release
amp: 1       // volume
out: 0       // output (L + R)
```
