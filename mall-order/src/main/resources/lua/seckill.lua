--
-- Created by IntelliJ IDEA.
-- User: pzh
-- Date: 2021/3/11
-- Time: 11:10
-- To change this template use File | Settings | File Templates.
-- 秒杀脚本

local userId = tonumber(ARGV[1])
local skuId = tonumber(ARGV[2])

-- 商品可用于秒杀数量hash表
local secSkuStock = KEYS[1]
-- 已经秒杀成功某件商品的用户hash表
local secSuccessUser = KEYS[2]

-- 判断操作用户是否已经秒杀成功该商品
if tonumber(redis.call('hget', secSuccessUser, userId)) == skuId then
    return '1'
end

-- 判断sku是否还有库存
local num = tonumber(redis.call('hget', secSkuStock, skuId))
if num <= 0 then
    return '2'
end;

-- 进行秒杀
-- sku库存-1
redis.call('hset', secSkuStock, skuId, num - 1)
-- 记录该用户已成功秒杀该商品
redis.call('hset', secSuccessUser, userId, skuId)
return '0'
