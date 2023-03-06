package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.core.Twitub;

public  class MesTwitsController {
    private IController controller;

    public MesTwitsController(IController controller){
        this.controller = controller;
    }

    public  void redirectMesTwits(){
        controller.showMyTwits();
    }
}
