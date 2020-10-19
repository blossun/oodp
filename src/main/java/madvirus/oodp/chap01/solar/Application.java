package madvirus.oodp.chap01.solar;

import madvirus.oodp.chap01.Button;
import madvirus.oodp.chap01.Component;
import madvirus.oodp.chap01.Menu;
import madvirus.oodp.chap01.OnClickListener;

public class Application { //Application이 OnClickListener을 구현하지 않음

    private Menu menu1 = new Menu("menu1");
    private Menu menu2 = new Menu("menu2");
    private Menu menu3 = new Menu("menu3");
    private Button button1 = new Button("button1");
    private Button button2 = new Button("button2");

    private ScreenUI currentScreen = null;

    public Application() {
        menu1.setOnClickListener(menuListener);
        menu2.setOnClickListener(menuListener);
        menu3.setOnClickListener(menuListener);
        button1.setOnClickListener(buttonListener);
        button2.setOnClickListener(buttonListener);
    }

    private OnClickListener menuListener = new OnClickListener() { //메뉴 이벤트 처리
        public void clicked(Component eventSource) {
            if (eventSource.getId().equals("menu1")) {
                currentScreen = new Menu1ScreenUI();
            } else if (eventSource.getId().equals("menu2")) {
                currentScreen = new Menu2ScreenUI();
            } else if (eventSource.getId().equals("menu3")) {
                currentScreen = new Menu3ScreenUI();
            }
            currentScreen.show();
        }
    };

    private OnClickListener buttonListener = new OnClickListener() { //버튼 이벤트 처리
        @Override
        public void clicked(Component eventSource) {
            if (currentScreen == null)
                return;
            if (eventSource.getId().equals("button1")) {
                currentScreen.handleButton1Click();
            } else if (eventSource.getId().equals("button2")) {
                currentScreen.handleButton2Click();
            }
        }
    };


}
