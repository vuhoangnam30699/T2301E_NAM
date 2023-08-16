public class CommonException extends RuntimeException {
    private Integer errorCode;
    private String extraInfo;

    public CommonException(Integer errorCode, String extraInfo) {
        super();
        this.errorCode = errorCode;
        this.extraInfo = extraInfo;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getExtraInfo() {
        return extraInfo;
    }
}
