# OE-Quirky

The _oe-qky-src_ folder contains a snapshot of OpenEmbedded and a "layer" for building a complete set of binary packages for creating Quirky Linux or Puppy Linux (or Easy Linux or other Puppy-derivative).  

Please note that the Quirky/Puppy distribution is not (yet) created in OpenEmbedded. The reality so far is that OE-Quirky "only" creates binary packages that must then be used in Woof* to build the Quirky/Puppy distribution.  

Woof-CE is the current build system for creating a Puppy distro from binary packages, and woofQ is the current build system for Quirky (and Easy). Currently only woofQ has '0pre-oe', a script for importing binary packages from the OE build.  

## Why?

Although woof* builds a distro from any binary packages, Barry has always been keen on having control of the entire cycle, from source code to final distribution.  
Using an existing binary repository, such as Debian, Ubuntu or Slackware, has enormous advantages, not least being binary compatibility with that repository -- and the Puppy Package Manager (PPM) is able to install any packages from that repository.  

However, there are downsides, such as unwanted dependencies, bloat, and being forced into certain architectural structures.  

Barry built some earlier versions of Puppy compiled entirely from source, using the T2 Project. This includes _Wary_ and _Racy_ Puppy -- back in 2013, but still very popular choices for people with older PCs. Then again, after forking to Quirky, _April_ in 2015.  

Having total control of the entire cycle means that very specific distros can be created. The main thing in comparison with Debian and Ubuntu will be a great reduction in bloat. In other words, Quirky/Puppy will be very small and fast.  

Barry is currently focusing on building a distro for surfing the Internet. Good web browser, multimedia player, printing.  

Another reply as to "why?" is that this is a very cool thing to do. Anyone with basic Linux skills should be able to download oe-qky-src and run a couple of simple commands and build an entire distro themselves ...then add and remove packages to create their own custom distro.  

## Requirements

You must be running a x86_64 host Linux system, and have expanded the oe-qky-src folder in a partition with Linux filesystem (preferably ext4) and at least 150GB free space. The PC must have at least 2GB RAM and there must be a swap partition.  

Barry has used both Quirky and Easy x86_64 as the host system. Describing each:  

### Quirky Linux x86_64  

The host Linux system used by the developer Barry Kauler is Quirky x86_64, version 8.1.6 (or later). This is built from Ubuntu 16.04 Xenial Xerus DEB packages, and as-is requires just a few tweaks to work with OpenEmbedded.  

For Quirky 8.1.6, it is required to install _python3_ and _ca-certificates_ from the Puppy Package Manager (PPM).  

To use _Toaster_, which is a GUI interface available in OE, it is also required to install _python3-django_, _python3-pip_ and _python-beautifulsoup_.  

Not to forget the full development environment, gcc, headers and the rest, which is, in the case of Quirky 8.1.6, a single PET package named _devx-8.1.6-xerus64.pet_.  

Itemizing, install these, as well as their dependencies:  
_devx, ca-certificates_, _python3_, _python3-django_, _python3-pip_, _python-beautifulsoup_  

### Easy OS x86_64  

At the time of writing, Easy is at version 0.9.4\. This is ready-to-go for OE. Nothing to do, it has all the dependencies.  

You do of course have to install the 'devx' SFS file, which provides everything needed for compiling (click the "sfsget" icon at top of screen.  

### Other distros

Puppy Linux x86_64 distributions should be OK also, in particular those based on Debian/Ubuntu DEBs (for example XenialPup).  

A couple more things to check in the host distro:  

OE expects the executable 'python2' and 'python3', so you might have to create symlinks. For example, "ln -s python3.5 /usr/bin/python3" and "ln -s python2.7 /usr/bin/python2"  

The 'ca-certificates' package should have installed lots of certificates in /etc/ssl/certs. If not, run "/usr/sbin/update-ca-certificates"  

## Getting started

In a Linux partition with at least 150GB free space, create a top-level folder with an appropriate name, for example "oe", then download 'oe-qky-src' from github.  

The download can be done in a few different ways. If you have 'git' installed, with a terminal open inside the 'oe' folder, run this:  

<pre># git clone https://github.com/bkauler/oe-qky-src.git oe-qky-src</pre>

Or, if you don't have 'ca-certificates' installed (meaning that the above won't work), then this will work:  

<pre># git clone git://github.com/bkauler/oe-qky-src.git oe-qky-src</pre>

To either of the above, you can append "--depth 1" if you don't want the history -- and the download is smaller.  

Or, you can download a zip file. Go to the github page in your browser and click on the "Download" button, then choose "Download zip". This will download 'oe-qky-src-master.zip' -- download into the "oe" folder.  

oe-qky-src site: [https://github.com/bkauler/oe-qky-src](https://github.com/bkauler/oe-qky-src)  

In Puppy and derivatives, you can right-click on the zip file and choose "Open with...", then "Xarchive" or "PupZip" to extract the files. They will extract to folder "oe-qky-src-master" -- rename that to just "oe-qky-src".  

OK, now to using it...  

<pre># cd oe-qky-src  
# ./create-oe-qky</pre>

Up-one level, you will see newly-created folders "downloads" and "oe-quirky". Folder "oe-quirky" has everything, and you can get setup to do a build:  

<pre># cd ../oe-quirky  
# source oe-init-build-env buildPC</pre>

Folder "buildPC" is building for a PC, x86_64 CPU. Alternatives are "buildPC32" for a PC with i686 32-bit CPU, and "buildarm64" for a generic aarch64 build.  

Target "buildPi" is for a Raspberry Pi2 and Pi3, however that is commented-out in the 'create-oe-qky' script. To use it, you might want to update the 'meta-raspberrypi' layer.  

A quick sanity test is to check that the layers are found:  

<pre># bitbake-layers show-layers</pre>

To do the actual build, you must have an Internet connection, a reasonably fast one -- if using wi-fi provided by a telco, 4G is strongly recommended over 3G.  
Also, a fast PC with plenty of RAM is required. Although OE state a minimum of 2GB RAM with swap partition, at least 4GB is recommended.  

Note that the Internet connection must be maintained throughout the build, as some packages, such as libreoffice, download extra source packages during compile.  
In otherwords, you cannot download all source packages prior to commencing the build.  

An annoyance is that libreoffice does not preserve the downloads globally for other builds. So, every time that libreoffice gets compiled, it has to download lots of extra packages.  

> **Notice**  
> LibreOffice is currently not in the package list in 'conf/local.conf' for buildPC, as it is an old version (5.0.6.3), plus the time it takes. Instead, Barry compiles LibreOffice in a running system (a distro built from the packages compiled in oe-qky-src!).

Off we go, for the next few hours (or days, depending on your PC):  

<pre># bitbake core-image-quirky</pre>

Barry's main PC for doing OE builds has a i5-4200 3.10GHz CPU, 16GB RAM and 1TB hard drive, and a build takes about 9 hours.  

Before or after the build, you can run this command to obtain lists of all chosen packages and their dependencies:  

<pre># bitbake -g core-image-quirky</pre>

...you will then see files "pn-buildlist", "task-depends.dot" and "recipe-depends.dot" in the "buildPC" folder.  

If you intend to export the packages to woofQ, the Quirky Linux build system, the above command is essential, as the files it produces are read by the packages-import script in woofQ.  

At the end of the build in OE, you will see many warning messages about incorrect packaging. These do not matter, as the export to woofQ does not use the OE packaging stage -- instead, the 'image' folder in each package build (which has the result of 'do_install') is read by woofQ and woofQ does its own packaging.  

Also, if for any reason the final step, 'do_rootfs', fails in OE, that does not matter, as woofQ builds its own rootfs.  

## Deploy

While still in the OE build environment, that is, a terminal in which you previously ran source <tt>oe-init-build-env buildPC</tt> (or <tt>source oe-init-build-env buildarm64</tt>, etc.), make sure that you run this:  

<pre># bitbake -g core-image-quirky</pre>

...this generates files "pn-buildlist", "recipe-depends.dot" and "task-depends.dot" in folder "buildPC". These are read when importing the binary packages into woofQ.  

Download the latest woofQ from here:  

[http://distro.ibiblio.org/easyos/project/woofq/](http://distro.ibiblio.org/easyos/project/woofq/)  

It will expand to folder "woof-project", and you will find "woof-project/quirky/README-FIRST" -- read that. Also look at "woof-project/quirky/woof-code/README.txt".  

Essentially, you will need to execute "./merge2out", which will create folder "woof-project/builds/<output-folder>".  

Open a terminal in "<output-folder>" and run "./0pre-oe". This will ask where the OE build is, and import the binary packages into woofQ.  

You will then be ready to do a build of Quirky or Easy, by running "./1setup", "./1download", "./2createpackages" and "./3buildeasydistro" in sequence.  

## About Quirky and Easy  

Quirky and Easy, originally forks of Puppy Linux, inherit the very small size yet with just about every package that you will need, as well as simplicity and power-to-the-user.  

To achieve the small size, careful choices are made of which packages and dependencies to use. It is useful to note what is _not_ in Quirky/Easy:  

> <font color="#ff0000">avahi esound</font> <font color="#ff0000"><font color="#ff0000">jack</font> multilib</font> <font color="#ff0000"><font color="#ff0000">pulseaudio</font> systemd</font>

Almost all GUI apps in Quirky/Easy are gtk+2 or x11 based.  

Many major applications, such as Firefox, SeaMonkey and LibreOffice, build with gtk+2\. In some cases, for example Evince, where gtk+2 has been abandoned, an older version is used, with patches to keep it "up to date".  

Another important factor is that there is a very prolific Puppy developer community, and there are hundreds of GUI applications specifically created for Puppy, most of them using gtk+2.  
Thus, we have no difficulty with populating a distro with an extensive suite of GUI utilities and applications with only gtk+2 and x11 available.  

However, gtk+3 is now provided in the build, and at the time of writing there is one gtk+3-based app in the build, Gnome-MPV multimedia player.  

Also, Qt5 is now in the build, and at the time of writing Scribus desktop publishing app is in the build.  

About Quirky itself, what is it?  
Quirky Linux was forked from Puppy Linux when Barry retired from maintaining the latter. Quirky is Barry's plaything, to experiment with new ideas. Consequently, there have been major architectural changes with different releases of Quirky. The recent offshoot Easy Linux, is another experimental architecture.  

## Links

Puppy related:  

*   Woof-CE: [http://murga-linux.com/puppy/viewtopic.php?t=101174](http://murga-linux.com/puppy/viewtopic.php?t=101174)  

*   Forum: [http://murga-linux.com/puppy/](http://murga-linux.com/puppy/)    

*   Home site: [http://puppylinux.com/](http://puppylinux.com/)     

Quirky related:  

*   Quirky x86_64 8.1.6: [http://bkhome.org/news/201701/quirky-816-x8664-released.html](http://bkhome.org/news/201701/quirky-816-x8664-released.html)    

*   Quirky x86_64 8.3: [http://bkhome.org/news/201707/quirky-xerus64-83-final.html](http://bkhome.org/news/201707/quirky-xerus64-83-final.html)  

*   Easy: [http://bkhome.org/easy/](http://bkhome.org/easy/)    

To find out more about what Barry is doing, read his blog:  
[http://bkhome.org/news](http://bkhome.org/news)
