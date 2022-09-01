# SampleTexto

Lee archivos de sonido de una carpeta por el número de índice que ocupan en ella.

## Preparación de SampleTexto
1 Descarga o clona la carpeta de SampleTexto.  
2 Colocala en la carpeta *Extensions* de SuperCollider.  
3 Crea una carpeta en *Recordings* de SuperCollider y nombrala <sampletexto>.  
4 Coloca tus sonidos en esa carpeta.  
	
## Inicia SampleTexto
```
r = SampleTexto.new;
```
## Prueba SampleTexto
```
r.sampleDictionary;
r.st(0).play;
r.st(0).plot;
r.stsel;
r.stm(0);
r.sts(0);
r.monosynth();
r.stereosynth();
r.info;

```
## Cambia la dirección de la carpeta
```
r.init(path: "/ruta/de/la/carpeta/")
```
## Ejemplo con Synth y Pdef
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
## Argumentos del SynthDef
```
// mono synth
rate: 1      // altura
sp: 0        // posición de lectura
at: 0.001    // ataque
sus: 1       // sostenimiento
rel: 0.001   // relajamiento
pan: 0       // panorama estéreo
amp: 1       // volumen
out: 0       // salida (Izquierda)

// mono synth
rate: 1      // altura
sp: 0        // posición de lectura
at: 0.001    // ataque
sus: 1       // sostenimiento
rel: 0.001   // relajamiento
amp: 1       // volumen
out: 0       // salida (Izquierda + Derecha)
```

