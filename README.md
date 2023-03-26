# dncomponents-java-elemental-starter
Starter project for development User interface with HTML binder using elemental2 elements.<br>
It demonstrates how to create your own components and
use it in html as any other elements.
This is basic project that only use core and mvp modules witth elemental2. If you want to use full dncomponents check [starter project with dncomponents](https://github.com/dncomponents/dncomponents-java-starter-bs).
## How to use
```
# clone project
$ git clone https://github.com/dncomponents/dncomponents-java-elemental-starter.git

# change directory to project folder
cd  dncomponents-java-elemental-starter

# Start developing and serve your app:
$ mvn gwt:devmode
```
For you convenience, install intellij dncomponents plugin.
https://plugins.jetbrains.com/plugin/13486-dn-components .
When editing html files it will generate needed code on a save. Just reload browser to see changes.

If you don't use Intellij and dncomponents plugin - after editing html files you'll have to either manually run a new terminal and execute:
```
$ mvn compile 
```
or run:
``` 
$ mvn fizzed-watcher:run
```
Which will monitor client folder for changes in html files and automatically run mvn compile command.
