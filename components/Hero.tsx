import Link from 'next/link';
import Image from 'next/image';

export default function Hero() {
  return (
    <section className="relative min-h-screen flex items-center justify-center pt-20 overflow-hidden">
      {/* Background image with overlay */}
      <div className="absolute inset-0 z-0">
        <Image
          src="/images/gallery-1.jpg"
          alt="Ферма Белая Дача"
          fill
          className="object-cover"
          priority
        />
        <div className="absolute inset-0 bg-gradient-to-br from-farm-cream/90 via-green-50/85 to-farm-cream/90"></div>
      </div>

      {/* Decorative elements */}
      <div className="absolute inset-0 overflow-hidden z-10">
        <div className="absolute top-20 left-10 w-64 h-64 bg-farm-green/10 rounded-full blur-3xl"></div>
        <div className="absolute bottom-20 right-10 w-96 h-96 bg-farm-green-light/15 rounded-full blur-3xl"></div>
      </div>

      <div className="container mx-auto px-4 text-center relative z-20">
        <div className="slide-up">
          <div className="inline-block mb-6">
            <span className="text-7xl">🌿</span>
          </div>
          <h1 className="text-5xl md:text-7xl font-bold text-farm-green mb-6">
            Белая Дача
          </h1>
          <p className="text-2xl md:text-3xl text-farm-earth mb-4 font-light">
            Семейная ферма натуральных овощей
          </p>
          <p className="text-lg md:text-xl text-farm-brown max-w-2xl mx-auto mb-10 leading-relaxed">
            Мы выращиваем свежие, сочные и ароматные овощи с любовью и заботой о природе.
            Каждый плод — результат нашего труда и уважения к земле.
          </p>
          <div className="flex flex-col sm:flex-row gap-4 justify-center">
            <Link
              href="#contact"
              className="bg-farm-green text-white px-10 py-4 rounded-full font-medium text-lg transition-all duration-300 hover:bg-farm-green-light hover:shadow-xl hover:scale-105"
            >
              Связаться с нами
            </Link>
            <Link
              href="#vegetables"
              className="bg-white text-farm-green border-2 border-farm-green px-10 py-4 rounded-full font-medium text-lg transition-all duration-300 hover:bg-farm-green hover:text-white hover:shadow-xl hover:scale-105"
            >
              Наши овощи
            </Link>
          </div>
        </div>
      </div>

      {/* Scroll indicator */}
      <div className="absolute bottom-8 left-1/2 transform -translate-x-1/2 animate-bounce z-20">
        <svg className="w-6 h-6 text-farm-green" fill="none" stroke="currentColor" viewBox="0 0 24 24">
          <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M19 14l-7 7m0 0l-7-7m7 7V3" />
        </svg>
      </div>
    </section>
  );
}
