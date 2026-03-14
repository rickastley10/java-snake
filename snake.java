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
            drawRect(bx, by, w, h, 0xff0000);
            if(dir=="up"){py=py-h;}
            if(dir=="down"){py=py+h;}
            if(dir=="right"){px=px+w;}
            if(dir=="left"){px=px-w;}
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
            else{
                turn=1;
                s1x=px;
                s1y=py;
                turn = turn + 1;
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