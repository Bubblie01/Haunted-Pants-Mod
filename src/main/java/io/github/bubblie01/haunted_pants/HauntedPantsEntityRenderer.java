package io.github.bubblie01.haunted_pants;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;

public class HauntedPantsEntityRenderer extends BipedEntityRenderer<HauntedPantsEntity, HauntedPantsEntityModel<HauntedPantsEntity>> {


	public HauntedPantsEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new HauntedPantsEntityModel(context.getPart(EntityModelLayers.PLAYER)), 0.5f);
		this.addFeature(new ArmorFeatureRenderer(this, new HauntedPantsEntityModel<> (context.getPart(EntityModelLayers.PLAYER_INNER_ARMOR)), new HauntedPantsEntityModel<> (context.getPart(EntityModelLayers.PLAYER_OUTER_ARMOR))));
	}

	public void render(HauntedPantsEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
		this.model.setVisible(false);
	}
}
