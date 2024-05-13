/**
 * @Description 生成一个18位的ID，模拟商品ID
 */
class Snowflake {

    // 构造函数，接收可选的 workerId、datacenterId 和 sequence 参数
    constructor(workerId = 0, datacenterId = 0, sequence = 0) {
        // 定义各部分所占位数
        this.workerIdBits = 5;
        this.datacenterIdBits = 5;
        this.sequenceBits = 13;

        // 最大的 workerId 和 datacenterId
        this.maxWorkerId = -1 ^ (-1 << this.workerIdBits);
        this.maxDatacenterId = -1 ^ (-1 << this.datacenterIdBits);

        // 各部分的位移
        this.workerIdShift = this.sequenceBits;
        this.datacenterIdShift = this.sequenceBits + this.workerIdBits;
        this.timestampLeftShift = this.sequenceBits + this.workerIdBits + this.datacenterIdBits;

        // 序列号的掩码
        this.sequenceMask = -1 ^ (-1 << this.sequenceBits);

        // 上次生成 ID 的时间戳
        this.lastTimestamp = -1;

        // 自动生成 workerId 和 datacenterId
        if (workerId === 0) {
            this.workerId = this.generateRandomId(this.maxWorkerId);
        } else {
            this.workerId = workerId;
        }
        if (datacenterId === 0) {
            this.datacenterId = this.generateRandomId(this.maxDatacenterId);
        } else {
            this.datacenterId = datacenterId;
        }

        // 初始化 sequence
        this.sequence = sequence;

        // 检查 workerId 和 datacenterId 是否在合法范围内
        if (this.workerId > this.maxWorkerId || this.workerId < 0) {
            throw new Error(`Worker ID must be between 0 and ${this.maxWorkerId}`);
        }
        if (this.datacenterId > this.maxDatacenterId || this.datacenterId < 0) {
            throw new Error(`Datacenter ID must be between 0 and ${this.maxDatacenterId}`);
        }
    }

    /* 生成下一个雪花算法ID */
    nextId() {
        // 获取当前时间戳
        let timestamp = this.timeGen();

        // 如果当前时间小于上次生成ID的时间戳，则抛出异常
        if (timestamp < this.lastTimestamp) {
            throw new Error(`Clock moved backwards. Refusing to generate id for ${this.lastTimestamp - timestamp} milliseconds`);
        }

        // 如果是同一时间生成的，则自增序列号
        if (this.lastTimestamp === timestamp) {
            this.sequence = (this.sequence + 1) & this.sequenceMask;
            // 如果序列号溢出，则等待下一毫秒
            if (this.sequence === 0) {
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }

        // 更新上次生成ID的时间戳
        this.lastTimestamp = timestamp;

        // 生成雪花算法ID
        const id = (BigInt(timestamp - 1288834974657) << BigInt(this.timestampLeftShift)) |
            (BigInt(this.datacenterId) << BigInt(this.datacenterIdShift)) |
            (BigInt(this.workerId) << BigInt(this.workerIdShift)) |
            BigInt(this.sequence);

        const idStr = id.toString();

        // 若后四位或者后三位均位0，则重写生成
        if (idStr.slice(-1) === '0' || idStr.slice(-2) === '00' || idStr.slice(-3) === '000' || idStr.slice(-4) === '0000') {
            // 重新生成 ID
            return this.nextId();
        }

        // 返回19位ID
        return idStr;
    }

    /* 获取当前时间戳 */
    timeGen() {
        return Date.now();
    }

    /* 等待下一毫秒 */
    tilNextMillis(lastTimestamp) {
        let timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    /* 生成指定范围内的随机数 */
    generateRandomId(max) {
        return Math.floor(Math.random() * (max + 1));
    }
}
