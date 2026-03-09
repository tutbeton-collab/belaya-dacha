'use client';

import { useState } from 'react';
import Image from 'next/image';

const galleryImages = [
  { src: '/images/gallery-1.jpg', alt: 'Свежие томаты' },
  { src: '/images/gallery-2.jpg', alt: 'Хрустящие огурцы' },
  { src: '/images/gallery-3.jpg', alt: 'Сладкие перцы' },
  { src: '/images/gallery-4.jpg', alt: 'Ароматная зелень' },
  { src: '/images/gallery-5.jpg', alt: 'Свежий урожай' },
  { src: '/images/gallery-6.jpg', alt: 'Наши грядки' },
];

export default function Gallery() {
  const [selectedImage, setSelectedImage] = useState<number | null>(null);

  return (
    <section id="gallery" className="section bg-white">
      <div className="container mx-auto px-4">
        <h2 className="section-title">Галерея</h2>
        <p className="section-subtitle">
          Фотографии с нашей фермы
        </p>

        <div className="grid grid-cols-2 md:grid-cols-3 gap-4 max-w-6xl mx-auto">
          {galleryImages.map((image, index) => (
            <div
              key={index}
              className="relative aspect-square rounded-xl overflow-hidden cursor-pointer hover-lift group"
              onClick={() => setSelectedImage(index)}
            >
              <Image
                src={image.src}
                alt={image.alt}
                fill
                className="object-cover group-hover:scale-110 transition-transform duration-300"
              />
              <div className="absolute inset-0 bg-gradient-to-br from-farm-green/10 to-farm-green-light/10 group-hover:from-farm-green/20 group-hover:to-farm-green-light/20 transition-colors duration-300"></div>
            </div>
          ))}
        </div>

        {/* Lightbox */}
        {selectedImage !== null && (
          <div
            className="fixed inset-0 bg-black/90 z-50 flex items-center justify-center p-4"
            onClick={() => setSelectedImage(null)}
          >
            <div className="relative max-w-5xl max-h-[85vh]">
              <Image
                src={galleryImages[selectedImage].src}
                alt={galleryImages[selectedImage].alt}
                width={1200}
                height={800}
                className="object-contain max-h-[85vh]"
              />
              <button
                className="absolute -top-8 -right-8 text-white text-5xl hover:text-farm-green-light transition-colors font-light"
                onClick={() => setSelectedImage(null)}
              >
                ×
              </button>
              <p className="text-white text-center mt-4 text-lg">
                {galleryImages[selectedImage].alt}
              </p>
            </div>
          </div>
        )}

        <p className="text-center text-farm-earth mt-8">
          📷 Больше фотографий доступны по запросу
        </p>
      </div>
    </section>
  );
}
