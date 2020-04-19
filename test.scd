s.boot

p = SampleTexto.new // constructor
p.sampleDictionary // para ver lo que hay adentro del directorio
p.sampleDictionary[\smp][5].play
p.sampleDictionary[\smp][0].plot

// deprecated
p.sample // llama directorio con ruta defult /"sampletexto"/

// accedo a directorio distinto
p.init(path: "/sonotexto/")

s.quit
