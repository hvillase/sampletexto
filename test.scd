s.boot;

p = SampleTexto.new // constructor
// Method 1: read sounds into folder of you Recordings path, avoid yo include other type of archives

p.sampleDictionary1 // to see Directory contents
p.init(pathRec: "/sonotexto/") // to change Directory into your Recordings folder
p.st1(0).play;
p.st1(0).plot; // to see the sound
p.st1(0).numChannels; // to se number of channels (mono:1, stereo: 2)
p.info(0); // gives you number of samples in </Recording/your_folder_path/>

// Method 2: read sounds everywhere, and the folder can contain other type of archives as text.
q = SampleTexto.new;
q.init(path: "/home/hvillase/Escritorio/MIRLCa/*"); // it is important to include * at end of the path
q.st2(0).play; // play the first sound archive in the folder
q.info(1) // gives you the number of archives, both sound and other type, in </your_folder_path/>

// Ndef test with reading Method 1 (</Recordings/your_folder/>)
Ndef(\ce1).play;
Ndef(\ce1).stop;

Ndef(\ce1, {var num1 = 8; PlayBuf.ar(p.st1(num1).numChannels, p.st1(num1), rate: 1, trigger: Impulse.kr([2, 4]), startPos: p.st1(num1).numFrames/4, loop: 0, doneAction: 2)});

// Tdef test
u = Pseq([16, 8, 32], inf).asStream;

(
Tdef(\ce, {
loop{
	1.do{
		{var num1 = rrand(66, 68);
		Out.ar(0, PlayBuf.ar(p.st1(num1).numChannels,
		bufnum: p.st1(num1).bufnum,
		rate: 1,
		startPos: p.st1(num1).numFrames/u.next,
		doneAction: 2) * EnvGen.kr(Env([0,1,1,0],[1, 6, 1])) * 1
		)}.play; 9.wait
};
	2.do{
		{var num1 = rrand(75, 80);
		Out.ar(0, PlayBuf.ar(p.st1(num1).numChannels,
		bufnum: p.st1(num1).bufnum,
		rate: 1,
		startPos: p.st1(num1).numFrames/2.1,
		doneAction: 2) * 1
		)}.play; 0.25.wait
	};
}
}).stop; // switch to play
)