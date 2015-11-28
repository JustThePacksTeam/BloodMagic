package WayofTime.bloodmagic.registry;

import WayofTime.bloodmagic.block.*;
import WayofTime.bloodmagic.item.block.*;
import WayofTime.bloodmagic.tile.TilePlinth;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import WayofTime.bloodmagic.BloodMagic;
import WayofTime.bloodmagic.ConfigHandler;
import WayofTime.bloodmagic.tile.TileAltar;
import WayofTime.bloodmagic.tile.TileImperfectRitualStone;
import WayofTime.bloodmagic.tile.TileMasterRitualStone;
import WayofTime.bloodmagic.util.helper.InventoryRenderHelper;

public class ModBlocks {
    public static Block altar;
    public static Block bloodRune;
    public static Block ritualController;
    public static Block ritualStone;
    public static Block testSpellBlock;
    public static Block pedestal;

    public static Block lifeEssence;

    public static Block crystal;
    public static Block bloodStoneBrick;

    public static void init() {
        FluidRegistry.registerFluid(BlockLifeEssence.getLifeEssence());
        lifeEssence = registerBlock(new BlockLifeEssence());

        altar = registerBlock(new BlockAltar());
        bloodRune = registerBlock(new BlockBloodRune(), ItemBlockBloodRune.class);
        ritualController = registerBlock(new BlockRitualController(), ItemBlockRitualController.class);
        ritualStone = registerBlock(new BlockRitualStone(), ItemBlockRitualStone.class);
        testSpellBlock = registerBlock(new BlockTestSpellBlock());
        pedestal = registerBlock(new BlockPedestal(), ItemBlockPedestal.class);
        bloodStoneBrick = registerBlock(new BlockBloodStoneBrick(), ItemBlockBloodStoneBrick.class);

        initTiles();
    }

    public static void initTiles() {
        GameRegistry.registerTileEntity(TileAltar.class, BloodMagic.MODID + ":" + TileAltar.class.getSimpleName());
        GameRegistry.registerTileEntity(TileImperfectRitualStone.class, BloodMagic.MODID + ":" + TileImperfectRitualStone.class.getSimpleName());
        GameRegistry.registerTileEntity(TileMasterRitualStone.class, BloodMagic.MODID + ":" + TileMasterRitualStone.class.getSimpleName());
        GameRegistry.registerTileEntity(TilePlinth.class, BloodMagic.MODID + ":" + TilePlinth.class.getSimpleName());
    }

    public static void initRenders() {
        InventoryRenderHelper renderHelper = BloodMagic.instance.getRenderHelper();

        renderHelper.fluidRender(lifeEssence);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodRune), 0);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodRune), 1);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodRune), 2);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodRune), 3);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodRune), 4);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodRune), 5);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodRune), 6);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodRune), 7);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodRune), 8);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodRune), 9);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(ritualController), 0);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(ritualController), 1);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(ritualStone), 0);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(ritualStone), 1);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(ritualStone), 2);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(ritualStone), 3);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(ritualStone), 4);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(ritualStone), 5);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(ritualStone), 6);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodStoneBrick), 0);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(bloodStoneBrick), 1);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(pedestal), 0);
        renderHelper.itemRender(InventoryRenderHelper.getItemFromBlock(pedestal), 1);
    }

    private static Block registerBlock(Block block, Class<? extends ItemBlock> itemBlock, String name) {
        if (!ConfigHandler.blockBlacklist.contains(name))
            GameRegistry.registerBlock(block, itemBlock, name);

        return block;
    }

    private static Block registerBlock(Block block, Class<? extends ItemBlock> itemBlock) {
        return registerBlock(block, itemBlock, block.getClass().getSimpleName());
    }

    private static Block registerBlock(Block block, String name) {
        if (!ConfigHandler.blockBlacklist.contains(name))
            GameRegistry.registerBlock(block, name);

        return block;
    }

    private static Block registerBlock(Block block) {
        return registerBlock(block, block.getClass().getSimpleName());
    }
}
