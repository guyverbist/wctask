## Simple word counter application

Build with `gradle[w] build`

Copy dependencies (if desired) with `gradle[w] copyToLib`

Then run either taking input from stdin, or a file e.g.

```
java -cp "build/deps/*;build/libs/*" org.gv.wctask.Wc
[your input]
<CR>
Ctrl-Z on windows
```

or

```
java -cp "build/deps/*;build/libs/*" org.gv.wctask.Wc sample.txt
```

The main class is also set up in the main jar manifest, so if the dependencies are in an appropriate location then the jar can be run directly with

```
java -jar build\libs\wctask.jar
```

