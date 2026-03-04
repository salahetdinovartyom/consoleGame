import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class HiddenKeyListener {
    public static class HiddenFrame extends JFrame {
        public HiddenFrame() {
            // Делаем окно невидимым
            setUndecorated(true);  // Убираем рамку
            setOpacity(0f);       // Полностью прозрачное
            setSize(1, 1);      // Минимальный размер
            setLocation(-100, -100); // Выносим за пределы экрана

            // Добавляем слушатель
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            System.out.println("↑ UP (в фоне)");
                            break;
                        case KeyEvent.VK_DOWN:
                            System.out.println("↓ DOWN (в фоне)");
                            break;
                        case KeyEvent.VK_LEFT:
                            System.out.println("← LEFT (в фоне)");
                            break;
                        case KeyEvent.VK_RIGHT:
                            System.out.println("→ RIGHT (в фоне)");
                            break;
                    }
                }
            });

            setFocusable(true);
            setVisible(true);
            requestFocusInWindow();
        }
    }

    public static void main(String[] args) {
        new HiddenFrame();
        System.out.println("Программа запущена. Нажмите стрелки (окно невидимо).");

        // Бесконечный цикл для поддержания работы
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
