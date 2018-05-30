package app.web;

/**
 * Status of Scheduling procedure.
 * 
 * @since 2018.05.17
 * @author annik
 */
public enum Status {

    PLANNED( "p", "Planned" ), // 
    IN_PROGRESS( "i", "In progress" ), // 
    FINISHED( "f", "Finished" ) //
    ;

    private String key;

    private String label;

    private Status( String key, String label ) {

        this.key = key;
        this.label = label;
    }

    public String getValue() {

        return this.key;
    }

    /**
     * @return plain text this Status.
     */
    public String getLabel() {

        return this.label;
    }

    public static Status keyOf( String key ) {

        Status result = null;
        for (Status item : Status.values()) {
            if ( key.equals( item.getValue() ) ) {
                result = item;
            }
        }
        return result == null ? PLANNED : result;
    }

}