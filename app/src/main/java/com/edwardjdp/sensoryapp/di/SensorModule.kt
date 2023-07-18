package com.edwardjdp.sensoryapp.di

import android.app.Application
import com.edwardjdp.sensoryapp.AccelerometerSensor
import com.edwardjdp.sensoryapp.GyroscopeSensor
import com.edwardjdp.sensoryapp.LightSensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {

    @Provides
    @Singleton
    fun provideLightSensor(app: Application): LightSensor {
        return LightSensor(app)
    }

    @Provides
    @Singleton
    fun provideAccelerometerSensor(app: Application): AccelerometerSensor {
        return AccelerometerSensor(app)
    }

    @Provides
    @Singleton
    fun provideGyroscopeSensor(app: Application): GyroscopeSensor {
        return GyroscopeSensor(app)
    }
}
