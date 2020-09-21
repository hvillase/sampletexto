s.boot

p = SampleTexto.new // constructor
p.st(2)
p.sampleDictionary // to see Directory contents
p.init(path: "/sonotexto/") // to access a diferente Directory in your Recordings
p.st(106).play // accede al indice de sampleo. Tengo acceso a él con ^this
p.st(10).plot
p.st(104).normalize.play // es Buffer encapsulado en una función {Buffer.read}
p.st(104).numChannels

// otra alternativa para acceder
p.sampleDictionary[\smp][2].plot
p.sampleDictionary[\smp][104].normalize.play // estoy leyendo los métodos de instancia de Buffer.play. Lo de arriba son Buffer.read accedo a ellos a través de Dictionary

// prueba en Ndef
Ndef(\ce1).stop.quant_(0)

Ndef(\ce1, {var num = 8; PlayBuf.ar(p.st(num).numChannels, p.st(num), rate: 1, trigger: Impulse.kr([8, 2]), startPos: p.st(num).numFrames/3.1, loop: 0, doneAction: 2) * 2.5})

// prueba con Tdef
u = Pseq([16, 8, 32], inf).asStream

(
Tdef(\ce, {
loop{
	1.do{
		{var num = rrand(66, 68);
		Out.ar(0, PlayBuf.ar(p.st(num).numChannels,
		bufnum: p.st(num).bufnum,
		rate: 1,
		startPos: p.st(num).numFrames/u.next,
		doneAction: 2) * EnvGen.kr(Env([0,1,1,0],[1, 6, 1])) * 1
		)}.play; 9.wait
};
	2.do{
		{var num = rrand(75, 80);
		Out.ar(0, PlayBuf.ar(p.st(num).numChannels,
		bufnum: p.st(num).bufnum,
		rate: 1,
		startPos: p.st(num).numFrames/2.1,
		doneAction: 2) * 1
		)}.play; 0.25.wait
	};
}
}).stop.quant_(0)
)