# DirTag
A java app that creates quick "cd" shortcuts for you

# Contents
* <a href="#Features">Features</a>
* <a href="#Installation">Installation</a>
* <a href="#Usage">Usage</a>
* <a href="#Example">Example</a>

<a id="Features"># Features
* Creates a directory tag (bash alias) that you can use to swiftly cd to the current directory
* The aliases can be stored in a file of your choice
* List all previously created aliases

# Installation
Please note that this app only works on unix based systems! (It may work with unix shell emulators however)
* Download the a jar file from the **Releases** tab and place in any directory
* Enter the following command, replacing __dir__ with the path to the current directory

```
$ alias dirtag='java -jar __dir__/DirTag.jar'
```
* Add the following lines to your __~/.bash_profile__ file (or whatever file is loaded when a new bash session is started). Replace __file__ with the path to the file you will store the aliases inside (The default is __~/.dirtags__).
```
if [ -f __file__ ]; then
  source__file__
fi
```

This will ensure that the dirtags are loaded when a new bash session is started.

# Usage
* When inside a directory that you'd like to make a shortcut/dirtag to, enter the follwoing command, replacing __name__ with the tag name.
```
$ dirtag __name__
```

* Now, start a new bash session, go to a totally different directory and enter the following command, replacing __name__ with the tag name.
```
$ cd__name__
```

* You will now have changed directory!

# Examples
