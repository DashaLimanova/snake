public class Apple {
    public int posX;
    public int posY;

    public Apple(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void setRandomPosition(){
        posX = Math.abs((int)(Math.random()*SnakeWindow.WIDTH-1));
        posY = Math.abs((int)(Math.random()*SnakeWindow.HEIGHT-1));
    }
}


