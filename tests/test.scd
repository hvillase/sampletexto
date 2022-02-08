s.boot;

SampleTexto.help;

p = SampleTexto.new // constructor
// Method 1: read sounds into folder of you Recordings path, avoid yo include other type of archives

p.sampleDictionary // to see Directory contents
p.init(path: "/sonotexto/") // to change Directory into your Recordings folder
p.st(0).play; // text sound in index 0, yo can change the index to listening other sounds
p.st(0).plot; // to see the sound
p.st(0).numChannels; // to se number of channels (mono:1, stereo: 2)

p.stsel; // to create a dictionary for mono and stereo files
p.stm(0).play; // to play mono sounds
p.sts(0).play; // to play stereo sounds
p.info; // gives you the number of samples in </Recording/your_folder_path/>

// Ndef test with reading Method 1 (</Recordings/your_folder_path/>)
Ndef(\ce1).play;
Ndef(\ce1).stop;

Ndef(\ce1, {var num1 = 8; PlayBuf.ar(p.st(num1).numChannels, p.st(num1), rate: 1, trigger: Impulse.kr([2, 4]), startPos: p.st(num1).numFrames/4, loop: 0, doneAction: 2)});

// Tdef test
u = Pseq([16, 8, 32], inf).asStream;

(
Tdef(\ce, {
loop{
	1.do{
		{var num1 = rrand(66, 68);
		Out.ar(0, PlayBuf.ar(p.st(num1).numChannels,
		bufnum: p.st(num1).bufnum,
		rate: 1,
		startPos: p.st(num1).numFrames/u.next,
		doneAction: 2) * EnvGen.kr(Env([0,1,1,0],[1, 6, 1])) * 1
		)}.play; 9.wait
};
	2.do{
		{var num1 = rrand(75, 80);
		Out.ar(0, PlayBuf.ar(p.st(num1).numChannels,
		bufnum: p.st(num1).bufnum,
		rate: 1,
		startPos: p.st(num1).numFrames/2.1,
		doneAction: 2) * 1
		)}.play; 0.25.wait
	};
}
}).stop; // switch to play
)