import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.concurrent.ThreadLocalRandom;

public class snake extends Canvas implements Runnable {

    /* ============================================================
       CONFIG
       ============================================================ */
    public static final int WINDOW_WIDTH  = 400;
    public static final int WINDOW_HEIGHT = 400;

    /* ============================================================
       GLOBALS
       ============================================================ */
    private BufferedImage backbuffer;
    private int[] pixels;
    private boolean running = true;
    
    // Keyboard input array
    private boolean[] keys = new boolean[256];
        



    int w = 20;
    int h = 20;
    
	
	
    int s1x = 999;
    int s1y = 999;
    int s2x = 999;
    int s2y = 999;
    int s3x = 999;
    int s3y = 999;
    int s4x = 999;
    int s4y = 999;
    int s5x = 999;
    int s5y = 999;
    int s6x = 999;
    int s6y = 999;
    int s7x = 999;
    int s7y = 999;
    int s8x = 999;
    int s8y = 999;
    int s9x = 999;
    int s9y = 999;
    int s10x = 999;
    int s10y = 999;
    int s11x = 999;
    int s11y = 999;
    int s12x = 999;
    int s12y = 999;
    int s13x = 999;
    int s13y = 999;
    int s14x = 999;
    int s14y = 999;
    int s15x = 999;
    int s15y = 999;
    int s16x = 999;
    int s16y = 999;
    int s17x = 999;
    int s17y = 999;
    int s18x = 999;
    int s18y = 999;
    int s19x = 999;
    int s19y = 999;
	int s20x = 999;
	int s20y = 999;
	
int s21x = 999; int s21y = 999;
int s22x = 999; int s22y = 999;
int s23x = 999; int s23y = 999;
int s24x = 999; int s24y = 999;
int s25x = 999; int s25y = 999;
int s26x = 999; int s26y = 999;
int s27x = 999; int s27y = 999;
int s28x = 999; int s28y = 999;
int s29x = 999; int s29y = 999;
int s30x = 999; int s30y = 999;
int s31x = 999; int s31y = 999;
int s32x = 999; int s32y = 999;
int s33x = 999; int s33y = 999;
int s34x = 999; int s34y = 999;
int s35x = 999; int s35y = 999;
int s36x = 999; int s36y = 999;
int s37x = 999; int s37y = 999;
int s38x = 999; int s38y = 999;
int s39x = 999; int s39y = 999;
int s40x = 999; int s40y = 999;

    int bx=ThreadLocalRandom.current().nextInt(1, 10) * 20;
    int by=ThreadLocalRandom.current().nextInt(1, 10) * 20;
    int level=1;
    int turn=1;
    int px = 200;
    int py = 300;
    String dir="up";

    /* ============================================================
       CONSTRUCTOR
       ============================================================ */
    public snake() {
        backbuffer = new BufferedImage(
                WINDOW_WIDTH,
                WINDOW_HEIGHT,
                BufferedImage.TYPE_INT_RGB
        );

        pixels = ((DataBufferInt) backbuffer.getRaster()
                .getDataBuffer()).getData();
                
        // Setup keyboard input
        setupKeyboard();
    }
    
    /* ============================================================
       KEYBOARD SETUP
       ============================================================ */
    private void setupKeyboard() {
        setFocusable(true);
        requestFocus();
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode >= 0 && keyCode < keys.length) {
                    keys[keyCode] = true;
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode >= 0 && keyCode < keys.length) {
                    keys[keyCode] = false;
                }
            }
        });
    }

    /* ============================================================
       RENDERER
       ============================================================ */
    public void clearScreen(int color) {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

    public void drawRect(int x, int y, int w, int h, int color) {
        for (int py = 0; py < h; py++) {
            int sy = y + py;
            if (sy < 0 || sy >= WINDOW_HEIGHT) continue;

            for (int px = 0; px < w; px++) {
                int sx = x + px;
                if (sx < 0 || sx >= WINDOW_WIDTH) continue;

                pixels[sy * WINDOW_WIDTH + sx] = color;
            }
        }
    }

    public void handleInput() {
        // A key - move left (KeyEvent.VK_A = 65)
        if (keys[KeyEvent.VK_A]) {
            
            dir="left";
        }
        // D key - move right
        if (keys[KeyEvent.VK_D]) {
            dir="right";
        }
        // A key - move left (KeyEvent.VK_A = 65)
        if (keys[KeyEvent.VK_W]) {
            
            dir="up";
        }
        // D key - move right
        if (keys[KeyEvent.VK_S]) {
            dir="down";
        }
    }

    /* ============================================================
       GAME LOOP
       ============================================================ */
    @Override
    public void run() {
        while (running) {
            // Example draw
            clearScreen(0x202020);      // dark gray
            handleInput();
            
            
            
            drawRect(px, py, w, h, 0x00ff00);
			
            drawRect(s1x, s1y, w, h, 0x00ff00);
            drawRect(s2x, s2y, w, h, 0x00ff00);
            drawRect(s3x, s3y, w, h, 0x00ff00);
            drawRect(s4x, s4y, w, h, 0x00ff00);
            drawRect(s5x, s5y, w, h, 0x00ff00);
            drawRect(s6x, s6y, w, h, 0x00ff00);
            drawRect(s7x, s7y, w, h, 0x00ff00);
            drawRect(s8x, s8y, w, h, 0x00ff00);
            drawRect(s9x, s9y, w, h, 0x00ff00);
            drawRect(s10x, s10y, w, h, 0x00ff00);
            drawRect(s11x, s11y, w, h, 0x00ff00);
            drawRect(s12x, s12y, w, h, 0x00ff00);
            drawRect(s13x, s13y, w, h, 0x00ff00);
            drawRect(s14x, s14y, w, h, 0x00ff00);
            drawRect(s15x, s15y, w, h, 0x00ff00);
            drawRect(s16x, s16y, w, h, 0x00ff00);
            drawRect(s17x, s17y, w, h, 0x00ff00);
            drawRect(s18x, s18y, w, h, 0x00ff00);
            drawRect(s19x, s19y, w, h, 0x00ff00);
            drawRect(s20x, s20y, w, h, 0x00ff00);
			drawRect(s21x, s21y, w, h, 0x00ff00);
            drawRect(s22x, s22y, w, h, 0x00ff00);
            drawRect(s23x, s23y, w, h, 0x00ff00);
            drawRect(s24x, s24y, w, h, 0x00ff00);
            drawRect(s25x, s25y, w, h, 0x00ff00);
            drawRect(s26x, s26y, w, h, 0x00ff00);
            drawRect(s27x, s27y, w, h, 0x00ff00);
            drawRect(s28x, s28y, w, h, 0x00ff00);
            drawRect(s29x, s29y, w, h, 0x00ff00);
            drawRect(s30x, s30y, w, h, 0x00ff00);
            drawRect(s31x, s31y, w, h, 0x00ff00);
            drawRect(s32x, s32y, w, h, 0x00ff00);
            drawRect(s33x, s33y, w, h, 0x00ff00);
            drawRect(s34x, s34y, w, h, 0x00ff00);
            drawRect(s35x, s35y, w, h, 0x00ff00);
            drawRect(s36x, s36y, w, h, 0x00ff00);
            drawRect(s37x, s37y, w, h, 0x00ff00);
            drawRect(s38x, s38y, w, h, 0x00ff00);
            drawRect(s39x, s39y, w, h, 0x00ff00);
            drawRect(s40x, s40y, w, h, 0x00ff00);
			
			
            drawRect(bx, by, w, h, 0xff0000);
            
            
            
            if(px==bx && py == by){
                level= level+1;
                bx=ThreadLocalRandom.current().nextInt(1, 10) * 20;
                by=ThreadLocalRandom.current().nextInt(1, 10) * 20;
            }

            if(level >= 1 && turn==1){
                s1x=px;
                s1y=py;
                turn = turn + 1;
            }

            else if(level >= 2 && turn==2){
                s2x=px;
                s2y=py;
                turn = turn + 1;
            }
            
            else if(level >= 3 && turn==3){
                s3x=px;
                s3y=py;
                turn = turn + 1;
            }
            
            else if(level >= 4 && turn==4){
                s4x=px;
                s4y=py;
                turn = turn + 1;
            }
            
            else if(level >= 5 && turn==5){
                s5x=px;
                s5y=py;
                turn = turn + 1;
            }
            
            else if(level >= 6 && turn==6){
                s6x=px;
                s6y=py;
                turn = turn + 1;
            }
            
            else if(level >= 7 && turn==7){
                s7x=px;
                s7y=py;
                turn = turn + 1;
            }
            
            else if(level >= 8 && turn==8){
                s8x=px;
                s8y=py;
                turn = turn + 1;
            }
            
            else if(level >= 9 && turn==9){
                s9x=px;
                s9y=py;
                turn = turn + 1;
            }
            
            else if(level >= 10 && turn==10){
                s10x=px;
                s10y=py;
                turn = turn + 1;
            }
            else if(level >= 11 && turn==11){
                s11x=px;
                s11y=py;
                turn = turn + 1;
            }

            else if(level >= 12 && turn==12){
                s12x=px;
                s12y=py;
                turn = turn + 1;
            }
            
            else if(level >= 13 && turn==13){
                s13x=px;
                s13y=py;
                turn = turn + 1;
            }
            
            else if(level >= 14 && turn==14){
                s14x=px;
                s14y=py;
                turn = turn + 1;
            }
            
            else if(level >= 15 && turn==15){
                s15x=px;
                s15y=py;
                turn = turn + 1;
            }
            
            else if(level >= 16 && turn==16){
                s16x=px;
                s16y=py;
                turn = turn + 1;
            }
            
            else if(level >= 17 && turn==17){
                s17x=px;
                s17y=py;
                turn = turn + 1;
            }
            
            else if(level >= 18 && turn==18){
                s18x=px;
                s18y=py;
                turn = turn + 1;
            }
            
            else if(level >= 19 && turn==19){
                s19x=px;
                s19y=py;
                turn = turn + 1;
            }
            
            else if(level >= 20 && turn==20){
                s20x=px;
                s20y=py;
                turn = turn + 1;
            }
			            else if(level >= 21 && turn==21){
                s21x=px;
                s21y=py;
                turn = turn + 1;
            }
            else if(level >= 22 && turn==22){
                s22x=px;
                s22y=py;
                turn = turn + 1;
            }
            else if(level >= 23 && turn==23){
                s23x=px;
                s23y=py;
                turn = turn + 1;
            }
            else if(level >= 24 && turn==24){
                s24x=px;
                s24y=py;
                turn = turn + 1;
            }
            else if(level >= 25 && turn==25){
                s25x=px;
                s25y=py;
                turn = turn + 1;
            }
            else if(level >= 26 && turn==26){
                s26x=px;
                s26y=py;
                turn = turn + 1;
            }
            else if(level >= 27 && turn==27){
                s27x=px;
                s27y=py;
                turn = turn + 1;
            }
            else if(level >= 28 && turn==28){
                s28x=px;
                s28y=py;
                turn = turn + 1;
            }
            else if(level >= 29 && turn==29){
                s29x=px;
                s29y=py;
                turn = turn + 1;
            }
            else if(level >= 30 && turn==30){
                s30x=px;
                s30y=py;
                turn = turn + 1;
            }
            else if(level >= 31 && turn==31){
                s31x=px;
                s31y=py;
                turn = turn + 1;
            }
            else if(level >= 32 && turn==32){
                s32x=px;
                s32y=py;
                turn = turn + 1;
            }
            else if(level >= 33 && turn==33){
                s33x=px;
                s33y=py;
                turn = turn + 1;
            }
            else if(level >= 34 && turn==34){
                s34x=px;
                s34y=py;
                turn = turn + 1;
            }
            else if(level >= 35 && turn==35){
                s35x=px;
                s35y=py;
                turn = turn + 1;
            }
            else if(level >= 36 && turn==36){
                s36x=px;
                s36y=py;
                turn = turn + 1;
            }
            else if(level >= 37 && turn==37){
                s37x=px;
                s37y=py;
                turn = turn + 1;
            }
            else if(level >= 38 && turn==38){
                s38x=px;
                s38y=py;
                turn = turn + 1;
            }
            else if(level >= 39 && turn==39){
                s39x=px;
                s39y=py;
                turn = turn + 1;
            }
            else if(level >= 40 && turn==40){
                s40x=px;
                s40y=py;
                turn = turn + 1;
            }
            else{
                turn=1;
                s1x=px;
                s1y=py;
                turn = turn + 1;
            }
            
            
            
            if(dir=="up"){py=py-h;}
            if(dir=="down"){py=py+h;}
            if(dir=="right"){px=px+w;}
            if(dir=="left"){px=px-w;}
            
if((s1x == px && s1y == py) ||
(s2x == px && s2y == py) ||
(s3x == px && s3y == py) ||
(s4x == px && s4y == py) ||
(s5x == px && s5y == py) ||
(s6x == px && s6y == py) ||
(s7x == px && s7y == py) ||
(s8x == px && s8y == py) ||
(s9x == px && s9y == py) ||
(s10x == px && s10y == py) ||
(s11x == px && s11y == py) ||
(s12x == px && s12y == py) ||
(s13x == px && s13y == py) ||
(s14x == px && s14y == py) ||
(s15x == px && s15y == py) ||
(s16x == px && s16y == py) ||
(s17x == px && s17y == py) ||
(s18x == px && s18y == py) ||
(s19x == px && s19y == py) ||
(s20x == px && s20y == py) || (s21x == px && s21y == py) || (s22x == px && s22y == py) || (s23x == px && s23y == py) || (s24x == px && s24y == py) || (s25x == px && s25y == py) || (s26x == px && s26y == py) || (s27x == px && s27y == py) || (s28x == px && s28y == py) || (s29x == px && s29y == py) || (s30x == px && s30y == py) || (s31x == px && s31y == py) || (s32x == px && s32y == py) || (s33x == px && s33y == py) || (s34x == px && s34y == py) || (s35x == px && s35y == py) || (s36x == px && s36y == py) || (s37x == px && s37y == py) || (s38x == px && s38y == py) || (s39x == px && s39y == py) || (s40x == px && s40y == py)){

	s1x = 999;
    s1y = 999;
    
    s2x = 999;
    s2y = 999;
    
    s3x = 999;
    s3y = 999;
    
    s4x = 999;
    s4y = 999;
    
    s5x = 999;
    s5y = 999;
    
    s6x = 999;
    s6y = 999;
    
    s7x = 999;
    s7y = 999;
    
    s8x = 999;
    s8y = 999;
    
    s9x = 999;
    s9y = 999;
    
    s10x = 999;
    s10y = 999;

    s11x = 999;
    s11y = 999;
    
    s12x = 999;
    s12y = 999;
    
    s13x = 999;
    s13y = 999;
    
    s14x = 999;
    s14y = 999;
    
    s15x = 999;
    s15y = 999;
    
    s16x = 999;
    s16y = 999;
    
    s17x = 999;
    s17y = 999;
    
    s18x = 999;
    s18y = 999;
    
    s19x = 999;
    s19y = 999;
    
    s20x = 999;
    s20y = 999;
	
	s21x = 999;
    s21y = 999;
    
    s22x = 999;
    s22y = 999;
    
    s23x = 999;
    s23y = 999;
    
    s24x = 999;
    s24y = 999;
    
    s25x = 999;
    s25y = 999;
    
    s26x = 999;
    s26y = 999;
    
    s27x = 999;
    s27y = 999;
    
    s28x = 999;
    s28y = 999;
    
    s29x = 999;
    s29y = 999;
    
    s30x = 999;
    s30y = 999;

    s31x = 999;
    s31y = 999;
    
    s32x = 999;
    s32y = 999;
    
    s33x = 999;
    s33y = 999;
    
    s34x = 999;
    s34y = 999;
    
    s35x = 999;
    s35y = 999;
    
    s36x = 999;
    s36y = 999;
    
    s37x = 999;
    s37y = 999;
    
    s38x = 999;
    s38y = 999;
    
    s39x = 999;
    s39y = 999;
    
    s40x = 999;
    s40y = 999;

    bx=ThreadLocalRandom.current().nextInt(1, 10) * 20;
    by=ThreadLocalRandom.current().nextInt(1, 10) * 20;
    level=1;
    turn=1;
    px = 200;
    py = 300;
    dir="up";
}


            repaint();

            try {
                Thread.sleep(100); // ~20 FPS (50ms = 20fps)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* ============================================================
       RENDER TO SCREEN
       ============================================================ */
    @Override
    public void paint(Graphics g) {
        g.drawImage(backbuffer, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
    
    /* ============================================================
       MAIN
       ============================================================ */
    public static void main(String[] args) {
        JFrame frame = new JFrame("snake");
        snake engine = new snake();

        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(engine);
        frame.setVisible(true);

        new Thread(engine).start();
    }
}
