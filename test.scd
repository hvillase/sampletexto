s.boot

p = SampleTexto.new // constructor
p.sampleDictionary // to see Directory contents
p.sampleDictionary[\smp][0].play
p.sampleDictionary[\smp][0].plot

// to access a diferente Directory in your Recordings
p.init(path: "/sonotexto/")

s.quit
