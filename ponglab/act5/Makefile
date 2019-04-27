JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Block.java \
	Locatable.java \
	Ball.java \
	BlinkyBall.java \
	Paddle.java \
	Pong.java \
	Wall.java\
	Collidable.java\
	Score.java\
	SpeedUpBall.java\
	InvisibleBall.java\
	TheGame.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
