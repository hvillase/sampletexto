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
