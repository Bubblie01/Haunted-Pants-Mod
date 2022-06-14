package io.github.bubblie01.haunted_pants;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;

public class HauntedPantsEntityModel<T extends HauntedPantsEntity> extends BipedEntityModel<T> {

	public HauntedPantsEntityModel(ModelPart modelPart) {
		super(modelPart);

	}

	public void setVisible(boolean visible) {
		super.setVisible(visible);
	}
}
