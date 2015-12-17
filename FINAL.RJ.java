// FINAL 
// REBECA JANOWICZ 
// CST 112 EVENING 

String title=  "CST112 FINAL," ;
String author=  "Rebeca Janowicz!";
String title1 =" Score=";
String news=" r= reset, q = exit,  t to send octopi to bottom";

String s="";
//
int many = 4;
//OCTUPI 
Octopi group[] = new Octopi[many];
String octopinames[] = { 
  "VICKY", "VIENNA", "SANTI", "NIKO" };
//LOBSTER
Lobster rjo [] = new Lobster[many];
String Lobsternames[]= { 
  "one", "two", "three", "four"};
// BOAT
Boat catcher [] = new Boat [many];
String boatnames[] = {  "Dom", "Val", "Pam", "Mark" };
Triangle[] tri= new Triangle[5];

//VARIABLES
float spacing;
float sea;
float sky = height/4;  
int score = 0;
// sun variables
float sunX= 0, sunY = 0;
float sunW = 40;
float sunH = 50;
float sunDX = .2;

void setup() {
  size(800, 700);
  smooth();

  spacing = width/(many+1);
  sky=height/4;
  reset();
  // boats
  for (int i = 0; i < catcher.length; i++) {
    catcher[i] = new Boat(boatnames[i]);
  }
}
void reset() {
  score = 0;
  sea= random(height/4, height/2);
  sunX = 0;
  sunY = sea;

  // spaces between octopus 
  float x=  spacing;
  for (int i=0; i < many; i++ ) {
    group[i]=  new Octopi( octopinames[i], x ); // spaces between octopus
    x += spacing;
  }

  for (int i=0; i<many; i++ ) {
    rjo[i]=  new Lobster ( Lobsternames[i]);       // Lobster
  }
  // triangle
  float yy=250; // this is new to prove a point. see min -13 on video
  float xx= 700;
  for (int i=0; i < tri.length; i++) {
    tri[i] = new Triangle(  xx, yy );  // best way to add triangles
   
    yy+=75;
    
    //xx+=10;
  }
}

// ARANGE BOATS BY X VALUES 
void sortBoatX( Boat [] b, int many ) {
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j < m; j ++) {
      if ( b [j].x > b[k].x) k = j;
    } 
    swapBoat( b, m-1, k);
  }
}
// ARRAGE BOATS BY DX VALUES FAST OR LOWEST
void sortBoatDX(Boat[] b, int many) {     
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (b[j].dx < b[k].dx) k = j;
    }
    swapBoat(b, m-1, k);
  }
}
// ARRAGE BOAT HIGHER TO LOWER VALUES 
void sortBoatCargo(Boat[] b, int many) {  
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (b[j].cargo < b[k].cargo) k = j;
    }
    swapBoat(b, m-1, k);
  }
}
// SWAP BOAT X,
void swapBoat(Boat[] b, int k, int j) {  

  Boat tmp;
  tmp= b[k];
  b[k]= b[j];
  b[j] = tmp;
} 

// ARRAGE OCTUPI by X VALUES
void sortOctopiX(Octopi[] o, int many) {

  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {

      if (o[j].x > o[k].x) k = j;
    }
    swapOctopi(o, m-1, k);
  }
}
// ARRAGE OCTUPI BY Y VALUES 
void sortOctopiY(Octopi[] o, int many) {

  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (o[j].y > o[k].y) k = j;
    }
    swapOctopi(o, m-1, k);
  }
}
// ARRAGE OCTUPI BY DY VALUES 
void sortOctopiDY(Octopi[] o, int many) {

  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (o[j].dy > o[k].dy) k = j;
    }
    swapOctopi(o, m-1, k);
  }
}
// ARRAGE OCTUPI BY NUMBER OF LEGS
void sortOctopiLegs(Octopi[] o, int many) {
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (o[j].legs > o[k].legs) k = j;
    }
    swapOctopi(o, m-1, k);
  }
}
void swapOctopi(Octopi[] o, int k, int j) {  

  Octopi tmp;
  tmp= o[k];
  o[k] = o[j];
  o[j] = tmp;
}

void sortLobsterX(Lobster[] l, int many) {        // Sorts the squids by X positions
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (l[j].x > l[k].x) k = j;
    }
    swapLobster(l, m-1, k);
  }
}
void sortLobsterY(Lobster[] l, int many) {        // Sorts the squids by Y positions
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (l[j].y > l[k].y) k = j;
    }
    swapLobster(l, m-1, k);
  }
}
// sort by legs was here
void swapLobster(Lobster[] l, int k, int j) {  
  Lobster tmp;
  tmp= l[k];
  l[k] = l[j];
  l[j] = tmp;
} 

/// GONE ADDING  
void draw () {
  scene();
  display();  // if left here everything stops to see report. 
  if (key >= 'A' && key <= 'Z') {
    boatReport(50, catcher, catcher.length); //this isn't doing it. 
    // boatReport( 50, catcher, 1 );
    fishReport( sky+50, group, group.length);
    lobsterReport(sky+50, rjo, rjo.length);
    messages();
  } else { 
    for (int i = 0; i < tri.length; i++) {
    tri[i].display(i);
    }
    messages();
    action();
  }
}
// draws background of sky and ocean
void scene() { 
  background(152, 162, 247); //sky color
  sunX*= 1;
  if (sunX > width-50) {
    sunX= -100;
    fill(255, 255, 0);
    ellipse(sunX, sunY-150*sin( PI * sunX/width ), sunW+10, sunH-10);
  }
  sunX += 1;
  fill(255, 255, 0);
  ellipse(sunX, sunY-150*sin( PI * sunX/width ), sunW+10, sunH-10);
  fill(167, 253, 255);       // sea color 
  rect(0, sea, width, height-sea);
}

void messages() {
  fill(0);
  textSize(12);
  text( title, 5, 690);
  text( news, 5, 660);
  text( author, 120, 690);
  text(title1, 5, sea);
  text(score, 55, sea);   //????
  textSize(12);
  text( "Hold B key to show position", 5, 550 );    // Instructions
  text( "Hold D to show speed order", 5, 565 );
  text( "Hold C key to show cargo order", 5, 585);
  text( "Hold X key to show octupi position", 5, 600 );
  text( "Hold Y key to show octopi's heigth", 5, 615);
  text( "Hold S key to show the speed ", 5, 631);
  text( "Hold L key for leg order", 5, 645);   
  text( "Hold F key for lobster report", 5, 675);
  //text( " hold t key to send octopi to bottom',
}
// Move octupus  & boats.
void action() { 
  //for (int i=0; i < many; i++ ) {  // octopus group
  for (int i=0; i < group.length; i++ ) {
    group[i].move();
  }
  //for (int i=0; i < many; i++ ) {  // boat
  for (int i=0; i < catcher.length; i++) {
    catcher[i].move();
  }
  // Lobster
  for (int i=0; i<many; i++ ) {   
    rjo[i].move();
  }
}
// show octopus and boat
void display() {
  float x=  spacing;
  for (int i=0; i<many; i++ ) {
    group[i].x=  x;
    x += spacing;
    group[i].show();
  }
  /// ***  boat display
  for (int i=0; i < many; i++ ) {  // boat
    catcher[i].show();
  }
  // Lobster display
  for (int i=0; i<many; i++ ) {     
    rjo[i].show();
  }
}
// Creates the report of boat properties
void boatReport( float top, Boat[] b, int many) {
  float x=60, y=top-20;
  fill(250, 154, 244, 250);
  rect( 50, top-40, 290, 100 );
  // Labels.
  fill(150, 0, 0);
  text( "Boat", x+10, y );
  text( "Cargo", x+60, y );
  text( "X", x+135, y );
  text( "DX", x+215, y );
  fill(0);
  //
  for (int i = 0; i < many; i++) {      
    y += 20;    // Next line.
    text( b[i].name, x+20, y );
    text( b[i].cargo, x+70, y );
    text( b[i].x, x+125, y );
    text( b[i].dx, x+205, y );
  }
}
// Creates the report of squid properties
void fishReport( float top, Octopi[] o, int many ) {
  float x=390, y=top-15;
  fill(189, 255, 157, 255);
  rect( 370, top-210, 390, 130 );
  // Labels.
  fill(150, 0, 0);
  text( "Octupi", x+10, 25 );
  text( "Legs", x+70, 25 );
  text( "X", x+145, 25 );
  text( "Y", x+215, 25 );
  text( "DY", x+315, 25);
  fill(0);
  for (int i=0; i<many; i++) {   
    y += 20;    // next line
    //text( i, x, y -190);
    text( o[i].name, x+10, y-190);
    text( o[i].legs, x+70, y-190 );
    text( o[i].x, x+135, y -190);
    text( o[i].y, x+205, y -190);
    text( o[i].dy, x+305, y -190);
  }
}

// Lobster REPORT
void lobsterReport( float top, Lobster[] s, int many ) {
  float x=390, y=top-15;
  fill(252, 202, 120, 252); 
  rect( 370, top-70, 390, 100 );
  // Labels.
  fill(150, 0, 0);
  text( "Lobster", x+10, 175 );
  text( "X", x+145, 175 );
  text( "Y", x+215, 175 );

  fill(0);
  for (int i=0; i<many; i++) {   
    y += 20;    // next line
    text( s[i].name, x+10, y-40);
    text( s[i].x, x+135, y -40);
    text( s[i].y, x+205, y -40);
  }
}

//// OBJECTS ////
class Octopi {
  float x, y; //dx, dy;       // Coordinates
  float dx=0, dy=0;  // Speed
  float w=45, h=40;
  int legs=10;      // Number of legs.
  String name="";
  float r, g, b;      // Color.
  int count=0;

  // CONSTRUCTORS //
  Octopi( String s, float x ) {
    this.name=  s;
    this.x=x;
    bottom();
    // octupi color
    r=  random( 200);
    g=  random( 225);
    b=  random(255);
  }

  //// Display the octupi.
  void show() {
    fill(r, g, b);
    stroke(r, g, b);
    ellipse( x, y, w, h );         // round top
    rect( x-w/2, y, w, h/2 );      // flat bottom
    // Legs   
    float legX=  x-w/2, foot=0;
    foot=  dy>=0 ? 0 : (y%45 > 23) ? 5 : -5;
    strokeWeight(3);
    // leg movement
    for (int i=0; i<legs; i++) {
      line( legX, y+h/2, legX+foot, 20+y+h/2 );
      legX += w / (legs-1);
    }
    strokeWeight(3);
    fill(120, 249, 252); // name and leg # color
    text( name, x-w/2, y-10+h/2 ); 
    text( legs, x+2-w/2, y+h/2 );
    fill(255);
    if (count>0) text( count, x, y+h/2 );
  }

  //// Start again at bottom.  (Random speed.)
  void bottom() {
    y=  height-h;
    dy=  -random( 1, 3);
    legs= int( random(1, 9) );
  }

  //// METHODS:  move & show ////
  void move() {
    // x += dx;
    y += dy;
    if (y < sea+15) { 
      //if (y >height) { 
      bottom();
      count++;
    } else if (y < sky) { 
      dy=  -3 * dy;        // Descend fast!
    }
  }
  //// Return true if near
  boolean hit( float xx, float yy ) {
    return dist( xx, yy, x, y ) < h;
  }
}

// BOAT CLASS
class Boat {
  String name="";
  float x, y, dx;
  float r, g, b;
  int cargo=0, caught=0;


  Boat(String n) {          // assign name, random x and dx
    this.name=  n;
    // x = random(0,width);
    //dx = random(-2, 3);

    x= random(30, width - 50);
    y = sea;
    dx = random(-4, 8);
    r = random(200);
    g = random(255);
    b = random(255, 255);
  }  

  //// Draw the boat
  void show() {
    // Boat
    fill(r, g, b);
    noStroke();
    rect( x, sea-20, 50, 30 ); // main body of boat
    if (dx > 0) { 
      triangle( x+50, sea+10, x+50, sea-20, x+70, sea-20 ); // front of boat
    } else {     
      triangle( x, sea+10, x, sea-20, x-20, sea-20);
    }
    fill(g, b, r);
    rect( x+12, sea-30, 25, 10 );  // Cabin.
    fill(0);
    rect( x+20, sea-40, 10, 10 );      // Smokestack.
    // Display name & cargo.
    fill(255);
    text( name, x+15, sea-10 );
    fill(0);
    text( cargo, x+20, sea+5 );
    fill( 50, 50, 50, 200 );
    ellipse( x +20 -10*dx, sea-50, 20, 20 );
    ellipse( x +20 -20*dx, sea-60, 15, 10 );
    ellipse( x +20 -30*dx, sea-70, 8, 5 );
  }    
  // MOVE  AND SCORE
  void move() {   

    int caught=0;
    x += dx;   
    if (x < 0 || x > width)  dx = -random( 0.5, 3 ); 
    for (int i = 0; i < group.length; i++) { 
      if (dist(x, y, group[i].x, group[i].y) < 70) { 
        cargo += group[i].legs; 
        group[i].bottom(); //
      }
    } 

    if (x < 0) {
      score += cargo;  
      cargo=0;
      caught = caught + cargo;
      dx = random( 1, 3 );
    }
  }
}
//// Begin shark class
class Lobster {
  // PROPERTIES 
  String name="";
  float x;  
  float dx=2;
  float y; 
  float dy;
  float hit=0;  //float= clawX;
// CONSTRUCTORS
  Lobster(String s) {          // assign name, random x and dx
    this.name=  s;
    x = 10;
    //clawX=100;
    y = random(sea +50, height);
    dx = random(-1, 3);
    dy = random(-1, 1);
  }  
  // METHODS-- 
  //moves salmon 
  void move() {               
    x += dx;         
    if (x<0) {
      dx = random( 1, 4 );     // lobster's speed
    }    
    if (x>width) {
      dx = -random( 1, 4 ); // go back
    }
    if (y < sea) {
      dy += random(-1, 1);
    }
 // octopi is sent to bottom if hit by lobster
  int caught=0;
    x += dx;   
    if (x < 0 || x > width)  dx = -random( 0.5, 3 ); 
    for (int i = 0; i < group.length; i++) { 
      if (dist(x, y, group[i].x, group[i].y) < 70) { 
        hit += group[i].legs; 
        group[i].bottom(); //
      }
    } 
  }
  // Draw the LOBSTER
  void show() {
    //float= clawX = 100;
    fill(255, 0, 0);
    noStroke();
    ellipse( x, y-20, 80, 40 );  // Lobster's body
    fill(0);
    // line(x-60,y-35, 100,10);
    if (dx>0) { 
      fill(0);
      ellipse(x+30, y-25, 5, 5);//eyes
      fill(0);
      strokeWeight(5);
      fill(255, 0, 0);
      ellipse(x+45, y-35, 40, 5); // arms
      ellipse(x+45, y-10, 40, 5); // arms
      //strokeWeight(5);
      fill(0);
    } else {           
      fill(0);
      ellipse(x-30, y-25, 5, 5); // eyes
      fill(255, 0, 0);
      ellipse(x-45, y-35, 40, 5); // arms
      ellipse(x-45, y-10, 40, 5); // arms
    }
    fill(255);
    text( name, x-20, y-15 );
    fill(0);
  }
}  
class Triangle {
    float x, y; //w= 70, h=40;
    
    Triangle() {
      x = 0;
      y = 250;
    }

    Triangle( float x, float y) {
      this.x = x;
      this.y = y;
    }
  void display ( int i) {
     //for (int y = 50; y <= sea; y += 50) { 
      fill(0,255,0);
      stroke(0);
      strokeWeight(1);
      fill(252,152,0);
      triangle(x+20, sea+40, x+60, sea+20, x+60, sea+60);
  }
 }
  // key functions
  void keyPressed() {
    if (key == 'r') reset();
    if (key == 'q') exit();
    if (key == 'B') { sortBoatX(catcher, catcher.length); } // arrages the x position
    if (key == 'D') { sortBoatDX(catcher, catcher.length ); } // arragnges boat's speed
    if (key == 'C') { sortBoatCargo(catcher, catcher.length ); } // arranges cargo 
    if (key == 'X') { sortOctopiX(group, group.length); } // Sort position (x)
    if (key == 'Y') { sortOctopiY(group, group.length); } // Sort height (y)
    if (key == 'S') { sortOctopiDY(group, group.length); } // Sort speed (dy)
    if (key == 'L') { sortOctopiLegs(group, group.length); }  // Sort # legs 
    if (key == 'F') { sortLobsterX(rjo, rjo.length); }
    
    // bring optupi to bottom
    if (key == 't') {
      for (int k=0; k < many; k++ ) {    // to the top
        group[k].y=  sea;
        group[k].dy=  -0.5;
      }
    }
  }
