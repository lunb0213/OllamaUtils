package aland.ollamaUtils.Map;

public class ResultMap extends OllamaMap {

    protected String created_at;
    protected Boolean done;
    protected String done_reason;
    protected Long total_duration;
    protected Long load_duration;
    protected Long prompt_eval_count;
    protected Long prompt_eval_duration;
    protected Long eval_count;
    protected Long eval_duration;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getDone_reason() {
        return done_reason;
    }

    public void setDone_reason(String done_reason) {
        this.done_reason = done_reason;
    }

    public Long getTotal_duration() {
        return total_duration;
    }

    public void setTotal_duration(Long total_duration) {
        this.total_duration = total_duration;
    }

    public Long getLoad_duration() {
        return load_duration;
    }

    public void setLoad_duration(Long load_duration) {
        this.load_duration = load_duration;
    }

    public Long getPrompt_eval_count() {
        return prompt_eval_count;
    }

    public void setPrompt_eval_count(Long prompt_eval_count) {
        this.prompt_eval_count = prompt_eval_count;
    }

    public Long getPrompt_eval_duration() {
        return prompt_eval_duration;
    }

    public void setPrompt_eval_duration(Long prompt_eval_duration) {
        this.prompt_eval_duration = prompt_eval_duration;
    }

    public Long getEval_count() {
        return eval_count;
    }

    public void setEval_count(Long eval_count) {
        this.eval_count = eval_count;
    }

    public Long getEval_duration() {
        return eval_duration;
    }

    public void setEval_duration(Long eval_duration) {
        this.eval_duration = eval_duration;
    }
}
