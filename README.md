# SampleTexto
Reading samples by index. This is a very experimental class. You can read an audio sample from a folder by its index.

## Preparing SampleTexto
1 Download or clone the folder of SampleTexto.

2 Put it in you SuperCollider Extensions folder.

3 Create a folder in SuperCollider Recordings folder and name it *sampletexto*.

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
r.info // says how many sounds are in total
```
## Change folder path
```
r.init(path: "/path/to/Recordings/your_folder/");
```
