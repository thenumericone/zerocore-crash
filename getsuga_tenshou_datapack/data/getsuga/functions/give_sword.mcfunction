# Give Getsuga Tenshou sword using 1.21.4 item components
give @s minecraft:netherite_sword[
  custom_name='{"text":"Getsuga Tenshou","color":"dark_blue","bold":true}',
  lore=[
    '{"text":"A legendary blade that channels","color":"gray","italic":true}',
    '{"text":"spiritual energy into devastating","color":"gray","italic":true}',
    '{"text":"horizontal strikes.","color":"gray","italic":true}',
    '{"text":"","color":"gray"}',
    '{"text":"Right-click to unleash Getsuga Tenshou!","color":"aqua","italic":false}'
  ],
  attribute_modifiers=[
    {
      type:"generic.attack_damage",
      amount:12.0,
      operation:"add_value",
      slot:"mainhand",
      id:"getsuga:attack_damage"
    },
    {
      type:"generic.attack_speed",
      amount:-2.0,
      operation:"add_value",
      slot:"mainhand",
      id:"getsuga:attack_speed"
    }
  ],
  enchantments={
    levels:{
      "minecraft:sharpness":3,
      "minecraft:unbreaking":2
    }
  },
  custom_data={getsuga_sword:true},
  custom_model_data=1
] 1

tellraw @s {"text":"Getsuga Tenshou sword given! Right-click to use the ability!","color":"green"}