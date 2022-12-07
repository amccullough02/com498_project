public class HighScore {

    private ArrayBag<Score> scores = new ArrayBag<>(100);

    public HighScore() {}

    public void addScore(Score score) {
        scores.addNewEntry(score);
    }

    public void viewScore() {

        if (scores.getCurrentSize() > 0) {

            // SORT HERE
            this.sortScores(0, scores.getCurrentSize()-1);

            String table = "";
            System.out.println("High Score Table\n---------------------");

            for (int i = 0; i < scores.getCurrentSize() && i < 5; i++) {
                scores.returnElement(i).printScore();
            }

            System.out.println("\n");

        }

        else if (scores.getCurrentSize() == 0){
            System.out.println("Table contains no entries - try again later.\n");
        }
        else {
            System.out.println("Error.");
        }
    }

    public void sortScores(int first, int last) {

        int pivot = scores.returnElement(last).getScore();
        int indexFromLeft = first, indexFromRight = last;

        while (indexFromLeft <= indexFromRight) {

            while(scores.returnElement(indexFromLeft).getScore() > pivot) indexFromLeft++;
            while(scores.returnElement(indexFromRight).getScore() < pivot) indexFromRight--;
            if (indexFromLeft <= indexFromRight) swap(indexFromLeft++, indexFromRight--);

        }

        if (first < indexFromRight) sortScores(first, indexFromRight);
        if (indexFromLeft < last) sortScores(indexFromLeft, last);

    }

    private void swap(int first, int second) {
        Score temp = scores.returnElement(first);
        scores.setEntryAt(first, scores.returnElement(second));
        scores.setEntryAt(second, temp);
    }

}
