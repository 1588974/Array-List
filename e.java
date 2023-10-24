public static void splitTheBlop(Monster curr) {
    if (!curr.canSplit()) {
        players[BLOPSPLIT] = new Player(); // Assuming Player is the appropriate class for players array
        curr.setHealth((int)(Math.random() * (101 - 50 + 1) + 50));
        curr.setCanSplit(true);
    } else {
        if (curr.getHealth() == 100) {
            int Number = (int)(Math.random() * (76 - 25 + 1) + 25);
            curr.damage(Number);
            players[BLOPSPLIT] = new Blop(curr.getRow(), curr.getCol(), playerImages[4]);
            curr.setCanSplit(false);
        }
    }
}
