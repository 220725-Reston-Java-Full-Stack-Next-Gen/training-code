# Computer Fundamentals

## Memory Structures

**CPU**: Central Processing Unit
- This is the brain of your computer. It's what actually executes instructions provided to it. 
- We do have/install an OS (Operating System)
    - a collection of software
    - but the CPU is hardware
- It's not a storage unit (it's not computer memory)
    - but it does have some slots for holding information/instructions/data
- Memory Addresses in the CPU as registers
- The CPU works very fast

**CPU Cache**
- Think of this like an easy access spot. 
- The CPU Cache is where the CPU can quickly grab things that it knows it's going to need
- N.B. Transferring information between different memory structures is very expensive

**RAM**: Random Access Memory
- This is an overarching term to refer to a lot of different kinds of *volatile* memory. 
- This is the section of memory that is being used when a program is actually running. 
- Each process that's running keeps information readily available for these programs to use.
    - So they each get their own section of memory (RAM).
- This is a form of **temporary storage**
    - it only stores information while the computer has power.

**Permanent Storage**
- Colloquially called Storage (temporary stuff is memory)
- This is another really broad category: 
    - Hard Disk
    - Flash Drumbs
    - External hard drive
    - CDs / DVDs / Floppy Disks
- These types of storage tend to be: 
    - cheaper (in the sense of resources)
    - larger (in size)


# OS Fundamentals
- The OS is a collection of software that manages computer hardware resources and provides common services for computer programs
- It acts as an interface between a computer user and the computer hardware
- It handles/performs basic tasks such as: 
    - File Management
    - Memory Management
    - Input / Output Management
        - Peripherals (keyboards, mice, headphones, printers, etc)
    - Process Management
- The above exist in the kernel space

- And we interact with the OS in the user space
    - we can use applications (aka the GUI - Graphical User Interface)
    - or we can use the command line interface

## Key Fundamental Terms
**Process**: a program that's executing (i.e. internet browser or text editor)  
**Program**: an application that we can run (i.e. Chrome, Word)  
**Shell**: a program that interprets text commands and sends them to the OS to execute

# Command Line (CLI)
- This is a text interface for your computer
- A program that takes in typed commands and then passes those commands to the computer's OS to run/execute.

**CLI vs GUI** 
Command Line Interface - interacting via text in the command line
Graphical User Interface - interacting via visuals/graphics (point and click)

## CMD.exe
- Commonly referred to as cmd or command prompt
- This is the default command line interpreter for Windows.


## Powershell
- The new (2006) Microsoft shell that combines the old CMD with a scripting instruction set
- Powershell is both a CLI *and* a scripting language
- Major difference between CMD and PowerShell is that PowerShell is object-oriented

## Bash
- Stands for Bourne Again Shell
- Command line and scripting language for Unix/Linux

# Common Commands
- ls
- cd
- pwd
- cat
- mkdir
- cp
- mv
- rm
- `|`
- `>`
- `>>`
- env
- echo
- export
- grep / findstr
- nano / vi

### Flags / Options / Arguments
With most CLI commands you can supply optional tags/flags along with arguments


### Sources
[More technical details about difference between PowerShell and CMD](https://www.varonis.com/blog/powershell-vs-cmd/)  
[This site has a nice breakdown chart](https://www.servertribe.com/difference-between-cmd-vs-powershell-vs-bash/)