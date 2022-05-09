package model;

import androidx.annotation.NonNull;

public enum StateEnum {
    NEW("New"),
    ASSIGNED("Not Done yet"),
    IN_PROGRESS("Working On It"),
    COMPLETE("Done");

    private final String taskState;


    StateEnum(String taskState) {
        this.taskState = taskState;
    }

    public String getTaskState() {
        return taskState;
    }

    public static StateEnum fromString(String taskStatesText) {
        for (StateEnum state : StateEnum.values()
        ) {
            if (state.taskState.equals(taskStatesText)) {
                return state;
            }
        }
        return null;
    }

    @NonNull
    @Override
    public String toString() {
        return taskState == null ? "" : taskState;
    }
}