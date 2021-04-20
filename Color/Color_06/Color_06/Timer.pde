class Timer {
    int savedTime;
    float totalTime;


    Timer (float _totalTime) {
        totalTime = _totalTime;
    }

    void start() {
        savedTime = millis();
    }

    boolean isFinished() {
        int passedTime = millis() - savedTime;
        if (passedTime > totalTime) {
            return true;
        } else {
            return false;
        }
    }
}