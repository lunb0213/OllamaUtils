package aland.ollamaUtils.Map;

import java.util.*;

/*
    {
        "model":"llama3",
        "prompt":"Why is the sky blue?",
        "stream":false,
        "options":{
        "num_keep":5,
        "seed":42,
        "num_predict":100,
        "top_k":20,
        "top_p":0.9,
        "min_p":0.0,
        "tfs_z":0.5,
        "typical_p":0.7,
        "repeat_last_n":33,
        "temperature":0.8,
        "repeat_penalty":1.2,
        "presence_penalty":1.5,
        "frequency_penalty":1.0,
        "mirostat":1,
        "mirostat_tau":0.8,
        "mirostat_eta":0.6,
        "penalize_newline":true,
        "stop":["\n","user:"],
        "numa":false,
        "num_ctx":1024,
        "num_batch":2,
        "num_gpu":1,
        "main_gpu":0,
        "low_vram":false,
        "f16_kv":true,
        "vocab_only":false,
        "use_mmap":true,
        "use_mlock":false,
        "num_thread":8
        }
    }
*/
public class GenerateRequestMap extends RequestMap {

    private String prompt;

    {
        prompt = "";
        //指定在生成新的输出时应该参考多少个最近的令牌（tokens）或单词。
        options.put("num_keep", 5);
        //设置用于生成的随机数种子。将此设置为特定数字将使模型为同一提示生成相同的文本。（默认值：0）
        options.put("seed", new Random().nextInt());
        //生成文本长度限制。（默认值：128，-1 = 无限生成，-2 = 填充上下文）
//        options.put("num_predict", 128);
        //模型的温度。提高温度会使模型更有创意地回答。（默认值：0.8）
        options.put("temperature", 0.9);
        //降低产生无意义的可能性。较高的值（例如 100）将给出更多样化的答案，而较低的值（例如 10）将更保守。（默认值：40）
        options.put("top_k", 40);
        //与 top-k 一起使用。较高的值（例如 0.95）将导致文本更加多样化，而较低的值（例如 0.5）将生成更集中和保守的文本。（默认值：0.9）
        options.put("top_p", 0.9);
        //替代top_p，旨在确保质量和多样性的平衡。参数 *p* 表示相对于最可能标记的概率，考虑标记的最小概率。例如，当 *p*=0.05 且最可能的标记的概率为 0.9 时，将筛选掉值小于 0.045 的 logit。（默认值：0.0）
        options.put("min_p", 0.0);
        //无尾采样用于减少输出中可能性较小的标记的影响。较高的值（例如 2.0）将减少更多影响，而值 1.0 将禁用此设置。（默认值：1）
        options.put("tfs_z", 0.5);
        //设置模型回溯多长时间以防止重复。（默认值：64,0 = 禁用，-1 = num_ctx）
        options.put("repeat_last_n", 72);
        //设置对重复项的惩罚强度。较高的值（例如 1.5）将更强烈地惩罚重复，而较低的值（例如 0.9）将更宽松。（默认值：1.1）
        options.put("repeat_penalty", 1.2);
        //控制生成文本中特定元素的出现频率。当设置为正值时，这个参数会增加生成常见元素（如常见单词或短语）的成本，从而减少这些元素在生成文本中的出现次数。这有助于避免生成过于普通或预期内的文本。
        options.put("presence_penalty", 2.0);
        //控制文本中单词或短语出现的频率。这个参数帮助调整生成文本的多样性，避免某些单词或短语被过度使用。
        options.put("frequency_penalty", 1.2);
        //启用 Mirostat 采样以控制困惑度。（默认值：0、0 = 禁用、1 = Mirostat、2 = Mirostat 2.0）
        options.put("mirostat", 1);
        //影响算法响应生成文本的反馈的速度。较低的学习率将导致较慢的调整，而较高的学习率将使算法的响应速度更快。（默认值：0.1）
        options.put("mirostat_tau", 0.8);
        //控制输出的连贯性和多样性之间的平衡。较低的值将导致文本更集中、更连贯。（默认值：5.0）
        options.put("mirostat_eta", 0.6);
        //处理文本或代码时是否对换行符进行惩罚或特殊处理
        options.put("penalize_newline", false);
        //设置要使用的停止序列。遇到此模式时，LLM 将停止生成文本并返回。可以通过在模型文件中指定多个单独的`stop`参数来设置多个停止模式。
        List<Object> var1 = new ArrayList<>();
        var1.add("user:");
        options.put("stop", var1);
        //是否启用非统一内存架构（NUMA）优化。
        options.put("numa", false);
        //上下文长度
        options.put("num_ctx", 4096);
        //模型将同时处理几个数据项。有助于提高处理效率，但可能增加内存使用。
        options.put("num_batch", 2);
        //指定使用几个GPU进行计算。
        options.put("num_gpu", 1);
        //指定主GPU的编号。
        options.put("main_gpu", 0);
        //是否使用低显存模式。
        options.put("low_vram", false);
        //是否使用半精度键值（float16）存储。使用半精度可以减少显存使用，有时也能加快计算速度，但可能会牺牲一些精度。
        options.put("f16_kv", true);
        //是否只使用词汇表数据。如果设置为true，模型可能只会使用词汇表进行处理，在某些特定的应用场景中可能有用。
        options.put("vocab_only", false);
        //是否使用内存映射文件。内存映射可以提高文件读取速度，特别是在处理大型文件时。
        options.put("use_mmap", true);
        //是否锁定物理内存。如果设置为true，系统会尝试锁定内存页，防止它们被交换出去，这可以提高性能但也可能影响系统的内存管理。
        options.put("use_mlock", false);
        //设置了并行处理时使用的线程数
        options.put("num_thread", 8);
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }


}
