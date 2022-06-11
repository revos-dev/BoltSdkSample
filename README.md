Overview

This section shows how to install the BOLT Bluetooth SDK, start your first charging session andvisualize the data in the Bolt Console.

Import SDK

To use the BOLT Android SDK, add the following dependency in your app’s build.gradle file:

	dependencies
	{
		/* BoltCore sdk */
		implementation ‘in.revos.android:bolt-ble:1.0.1'
	}

Initialize the Bolt SDK

Initialize the BOLT BLE SDK as mentioned below:

	val boltManager = BoltSdk.getBoltManager(lifecycleOwner Object, context, bookingObject)

Pass the entire ongoing bookingObject as a String. Booking object can be received from BOLT apis on successfully creating a booking. For more details on BOLT apis, refer the BOLT apis documentation.