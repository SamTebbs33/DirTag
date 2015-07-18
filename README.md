# DirTag

[![Join the chat at https://gitter.im/SamTebbs33/DirTag](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/SamTebbs33/DirTag?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
A java app that creates quick "cd" shortcuts for you

In the below example, I use a custom command **rl** to reload my **.bash_profile** file, which loads the new dirtag. It is just an alias for ". ~/.bash_profile"

![alt tag](https://github.com/SamTebbs33/DirTag/blob/master/example.gif)

Please note that it will only work on UNIX based systems, or perhaps programs that emulate one (not tested).

# Contents
* <a href="#Features">Features</a>
* <a href="#Installation">Installation</a>
* <a href="#Usage">Usage</a>

<a id="Features">Features
==========================
* Creates a directory tag (bash alias) that you can use to swiftly cd to the current directory
* The aliases can be stored in a file of your choice (soon!)
* List all previously created aliases (soon!)

<a id="Installation">Installation
==========================
Please note that this app only works on unix based systems! (It may work with unix shell emulators however)
* Download the a jar file from the **Releases** tab and place in any directory
* Enter the following command, replacing __dir__ with the path to the current directory

```
$ alias dirtag='java -jar dir/DirTag.jar'
```
* Add the following lines to your __~/.bash_profile__ file (or whatever file is loaded when a new bash session is started). 
```
if [ -f ~/.dirtags ]; then
  source ~/.dirtags
fi
```

This will ensure that the dirtags are loaded when a new bash session is started.

<a id="Usage">Usage
==========================
* When inside a directory that you'd like to make a shortcut/dirtag to, enter the follwoing command, replacing __name__ with the tag name.
```
$ dirtag name
```

* Now, start a new bash session, go to a totally different directory and enter the following command, replacing __name__ with the tag name.
```
$ cdname
```

* You will now have changed directory!
