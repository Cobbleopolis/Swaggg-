package com.cobble.swaggg

import com.cobble.swaggg.block.BlockTest
import com.cobble.swaggg.proxy.CommonProxy
import com.cobble.swaggg.reference.{SwagggBlocks, Reference}
import net.minecraft.block.Block
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.entity.RenderItem
import net.minecraft.client.resources.model.ModelResourceLocation
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.common.{SidedProxy, Mod}
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.relauncher.Side

@Mod(modid = "swaggg", name = "Swaggg", version = "0.0.0", modLanguage = "scala") //DO NOT CHANGE THE MODID OR THE MODNAME W/O UPDATING THE REFERENCE FILE
object Swaggg {

    @Mod.Instance(value = "swaggg")
    var swaggg = null

    @SidedProxy(clientSide="com.cobble.swaggg.proxy.ClientProxy", serverSide="com.cobble.swaggg.proxy.CommonProxy")
    var proxy: CommonProxy = null

    @EventHandler
    def preInit(e: FMLPreInitializationEvent): Unit = {
        SwagggBlocks.preInit()
    }

    @EventHandler
    def init(event: FMLInitializationEvent): Unit = {
        System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName)
        //register renders
        SwagggBlocks.init(event)
    }

    @EventHandler
    def postInit(e: FMLPostInitializationEvent): Unit = {}
}
