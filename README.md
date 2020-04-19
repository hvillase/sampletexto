# SampleTexto
Reading samples by index. This is a very experimental class. You can just read a sample from a folder by its index.

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
r.sampleDictionary[\smp][0].play // to play the first sample in you folder; change the number to acces different index.
r.sampleDictionary[\smp][0].plot // to see the waveform of your sample.
```