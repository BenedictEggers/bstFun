# A Makefile for Java?? Blasphemy!

JC = javac
JFLAGS = -g

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AbstractBST.java \
	BST.java \
    RotatingBST.java \
	Treap.java \
    TreeStats.java \
	BSTMain.java

all: classes

classes: $(CLASSES:.java=.class)

clean:
	rm -f *.class
