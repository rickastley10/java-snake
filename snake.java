import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

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
    
    int dir = 1;

    int player_x = 200;
    int player_y = 200;

    int[] segment_x = new int[400];
    int[] segment_y = new int[400];



    int segments = 2;
    int pointer = 0;

    int berry_x=300;
    int berry_y=300;


    int pause = 0;


    /* ============================================================
       CONSTRUCTOR
       ============================================================ */
    public snake() {
            segment_x[0] = 220;
            segment_x[1] = 240;
            segment_x[2] = 260;

            segment_y[0] = player_y;
            segment_y[1] = player_y;
            segment_y[2] = player_y;
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
        if (keys[KeyEvent.VK_A] && dir != 2) {
            
            dir=4;
        }
        // D key - move right
        if (keys[KeyEvent.VK_D] && dir != 4) {
            dir=2;
        }
        // A key - move left (KeyEvent.VK_A = 65)
        if (keys[KeyEvent.VK_W] && dir != 3) {
            
            dir=1;
        }
        // D key - move right
        if (keys[KeyEvent.VK_S] && dir != 1) {
            dir=3;
        }
        // Arrow Left key
        if (keys[KeyEvent.VK_LEFT] && dir != 2) {
            dir = 4;
        }
        // Arrow Right key
        if (keys[KeyEvent.VK_RIGHT] && dir != 4) {
            dir = 2;
        }
        // Arrow Up key
        if (keys[KeyEvent.VK_UP] && dir != 3) {
            dir = 1;
        }
        // Arrow Down key
        if (keys[KeyEvent.VK_DOWN] && dir != 1) {
            dir = 3;
        }


        if (keys[KeyEvent.VK_SPACE]) {
            if(pause==0){pause=1;}
            else{pause=0;}
        }
    }

    /* ============================================================
       GAME LOOP
       ============================================================ */
    @Override
    public void run() {
        while (running) {
            if(pause==0){
                if(dir==1){
                    player_y=player_y-20;
                }
                if(dir==2){
                    player_x=player_x+20;
                }
                if(dir==3){
                    player_y=player_y+20;
                }
                if(dir==4){
                    player_x=player_x-20;
                }
                
                for (int i = 0; i <= segments; i++){
                    if(player_x == segment_x[i] && player_y == segment_y[i]){
                        for (int ix = 0; ix <= segments; ix++){
                            segment_x[ix] = 999;
                            segment_y[ix] = 999;

                        }
                        segments=0;
                        dir = 1;
                        player_x = 200;
                        player_y = 200;
                        segments = 2;
                        pointer = 0;
                        berry_x=300;
                        berry_y=300;

                    }
                }
                if(player_x==berry_x && player_y == berry_y){
                    System.out.println("score : " + (segments+2));
                    berry_x= ThreadLocalRandom.current().nextInt(1, 19) * 20;
                    berry_y= ThreadLocalRandom.current().nextInt(1, 18) * 20;
                    segment_x[segments+1] = 999;
                    segment_y[segments+1] = 999;
                    segments++;
                }

                if(player_x>400){
                    player_x=0;
                }
                else if(player_x<0){
                    player_x=400;
                }
                else if(player_y>380){
                    player_y=0;
                }
                else if(player_y<0){
                    player_y=380;
                }


                segment_x[pointer] = player_x;
                segment_y[pointer] = player_y;
                pointer++;
                if(pointer>segments){
                    pointer=0;
                }

            }
            

            // Example draw
            clearScreen(0x202020);      // dark gray
            handleInput();
            
            
            drawRect(player_x, player_y, w, h, 0x00ff00);
            for (int i = 0; i <= segments; i++){
                drawRect(segment_x[i], segment_y[i], w, h, 0x00ff00);
            }

            drawRect(berry_x, berry_y, w, h, 0xff0000);

            



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