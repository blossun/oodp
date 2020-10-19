package madvirus.oodp.chap01.solar;

import madvirus.oodp.chap01.Button;
import madvirus.oodp.chap01.Component;
import madvirus.oodp.chap01.Menu;
import madvirus.oodp.chap01.OnClickListener;

public class Application implements OnClickListener {

    private Menu menu1 = new Menu("menu1");
    private Menu menu2 = new Menu("menu2");
    private Button button1 = new Button("button1");

    private ScreenUI currentScreen = null;

    public Application() {
        menu1.setOnClickListener(this);
        menu2.setOnClickListener(this);
        button1.setOnClickListener(this);
    }

    @Override
    public void clicked(Component eventSource) {
        if (eventSource.getId().equals("menu1")) {
            currentScreen = new Menu1ScreenUI();
            currentScreen.show();
        } else if (eventSource.getId().equals("menu2")) {
            currentScreen = new Menu2ScreenUI();
            currentScreen.show();
        } else if (eventSource.getId().equals("button1")) {
            if (currentScreen == null)
                return;
            currentScreen.handleButton1Click(); //메뉴1 화면인지 메뉴2 화면인지에 상관없이 currentScreen의 메서드를 실행
        }
    }

}
