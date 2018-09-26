# makefile lab_3

.SUFFIXES: .class .java

PACK=lab_3
TARG=Test
JC=javac -g
JM=java -ea -jar
JR=jar -cfe

OBJ=$(PACK)\NonlinearEquation.class \
    $(PACK)\Test.class

.java.class:
	$(JC) $<

run: build
	$(JM) $(TARG).jar

build: 	$(OBJ)
	$(JR) $(TARG).jar $(PACK).Test $(OBJ)

clean:
	for %%f in ($(OBJ)) do del %%f
	del $(TARG).jar

$(PACK)\NonlinearEquation.class: $(PACK)\NonlinearEquation.java makefile

$(PACK)\Test.class: $(PACK)\Test.java makefile

# eof makefile lab_3
